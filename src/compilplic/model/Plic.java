/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.model;

import compilplic.analyse.AnalyseurLexical;
import compilplic.analyse.AnalyseurSyntaxique;
import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import compilplic.lexique.Lexique;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author mick
 */
public class Plic {
    
    private StringBuilder contenu_fichier ;
    private File f ;
    private File f_dest;

    public Plic(String chemin_src) throws IOException, Exception {
        lireFichier(chemin_src) ;
        AnalyseurSyntaxique as = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(contenu_fichier.toString())));
        Lexique l = (Lexique)as.parse().value ;
        //System.out.println(TDS.getInstance());
        l.verifier();
        if(GestionnaireSemantique.getInstance().size() != 0)
            for (SemantiqueException s : GestionnaireSemantique.getInstance())
                System.out.println("ERREUR SEMANTIQUE : "+s.getMessage());
        else{
            f_dest = new File(f.getAbsolutePath().replaceAll("\\.plic", ".asm"));
            writeMips(l);
            System.out.println("COMPILATION OK");
        }
    }

    public Plic(String chemin_src, String chemin_dest) throws IOException, Exception {
        lireFichier(chemin_src) ;
        AnalyseurSyntaxique as = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(contenu_fichier.toString())));
        Lexique l = (Lexique)as.parse().value ;
        l.verifier();
        //Initialisation pour savoir s'il s'agit d'un fichier ou d'un dossier
        f_dest=new File(chemin_dest);
        
        //Si le nom du fichier fini par / ou \ (Windows), il s'agit d'un repertoire
        if(f_dest.getAbsolutePath().endsWith("[/\\]")){
            f_dest = new File(chemin_dest+f.getName().replaceAll("\\.plic", ".asm"));
            writeMips(l);
        }else{
            //S'il s'agit d'un repertoire
            if(f_dest.isDirectory()){
                f_dest = new File(chemin_dest+"/"+f.getName().replaceAll("\\.plic", ".asm"));
                writeMips(l);
            }else{
                //Si le nom du fichier fini par .plic, c'est un fichier plic
                if(f_dest.getAbsolutePath().endsWith(".plic"))
                    f_dest = new File(chemin_dest.replaceAll("\\.plic", ".asm"));
                if(!f_dest.getName().endsWith(".asm"))
                    f_dest=new File(f_dest.getAbsolutePath().concat(".asm"));
                writeMips(l);
            }
        }
        System.out.println("COMPILATION OK");
    }
    
    private void writeMips(Lexique l) throws IOException {
        String s = l.ecrireMips() ;
        PrintWriter mips = new PrintWriter(f_dest) ;
        mips.printf(s);
        mips.close();
    }

    private void lireFichier(String chemin_ficher) throws FileNotFoundException, IOException {
        contenu_fichier = new StringBuilder() ;
        f = new File(chemin_ficher) ;
        if(!f.getName().endsWith(".plic"))
            throw new ArrayIndexOutOfBoundsException() ;
        BufferedReader b = new BufferedReader(new FileReader(f)) ;
        String line = null ;
        while((line= b.readLine()) != null)
            contenu_fichier.append(line+"\n") ;
    }
}
