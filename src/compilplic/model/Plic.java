/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.model;

import compilplic.analyse.AnalyseurLexical;
import compilplic.analyse.AnalyseurSyntaxique;
import compilplic.lexique.expression.Expression;
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

    public Plic(String chemin_fichier) throws IOException, Exception {
        lireFichier(chemin_fichier) ;
        AnalyseurSyntaxique as = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(contenu_fichier.toString())));
        Expression e = (Expression)as.parse().value ;
        e.verifier();
        f_dest = new File(f.getAbsolutePath().replaceAll("\\.plic", ".asm"));
        writeMips(e);
        System.out.println("COMPILATION OK");
    }

    public Plic(String chemin_fichier, String chemin_dest) throws IOException, Exception {
        lireFichier(chemin_fichier) ;
        AnalyseurSyntaxique as = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(contenu_fichier.toString())));
        Expression e = (Expression)as.parse().value ;
        e.verifier();
        //Initialisation pour savoir s'il s'agit d'un fichier ou d'un dossier
        f_dest=new File(chemin_dest);
        
        //Si le nom du fichier fini par .plic, c'est un fichier plic
        if(f_dest.getAbsolutePath().endsWith(".plic"))
            f_dest = new File(chemin_dest.replaceAll("\\.plic", ".asm"));
        
        //Si le nom du fichier fini par / ou \ (Windows), il s'agit d'un repertoire
        if(f_dest.getAbsolutePath().endsWith("[/\\]")){
            f_dest = new File(chemin_dest+f.getName().replaceAll("\\.plic", ".asm"));
            writeMips(e);
        }else{
            //S'il s'agit d'un repertoire
            if(f_dest.isDirectory()){
                f_dest = new File(chemin_dest+"/"+f.getName().replaceAll("\\.plic", ".asm"));
                writeMips(e);
            }else
                writeMips(e);
        }
        System.out.println("COMPILATION OK");
    }
    
    private void writeMips(Expression e) throws IOException {
        String s = e.ecrireMips() ;
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
