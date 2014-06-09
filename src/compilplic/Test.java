/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.analyse.AnalyseurLexical;
import compilplic.analyse.AnalyseurSyntaxique;
import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import compilplic.lexique.Bloc;
import compilplic.lexique.Lexique;
import compilplic.lexique.expression.Expression;
import compilplic.tds.TDS;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 *
 * @author ASUS
 */
public class Test {

    private File f ;
    private StringBuilder contenu_fichier ;
    
    public Test(String [] args) throws IOException, Exception {
        String texte = lireFichier(args[0]) ;
        AnalyseurLexical lex = new AnalyseurLexical(new StringReader(texte)) ;
        AnalyseurSyntaxique s = new AnalyseurSyntaxique(lex) ;
        Lexique l = (Lexique) s.parse().value ;
        TDS tds = TDS.getInstance() ;
        System.out.println("lexique = \n"+l);
        for (Bloc b : l.getListe_bloc())
            System.out.println(b) ;
        System.out.println("tds = \n"+tds);
        boolean b = l.verifier();
        String mips = l.ecrireMips();
        System.out.println(mips);
        if(GestionnaireSemantique.getInstance().size() != 0){
            for (SemantiqueException se : GestionnaireSemantique.getInstance())
                System.out.println("ERREUR SEMANTIQUE : "+se.getMessage());
            System.out.println("ERREUR !");
        }else{
            System.out.println("FINI !");
        }
    }
    
    private void writeMips(String mips, String filename) throws IOException {
        PrintWriter f = new PrintWriter(new File(filename)) ;
        f.printf(mips);
        f.close();
    }
    
    private void writeDot(Expression e, String filename) throws IOException {
        String s = "digraph { \n" ;
        s+= e.ecrireDot();
        s+="}" ;
        PrintWriter dot = new PrintWriter(new File(filename+".dot")) ;
        dot.printf(s);
        dot.close();
        Runtime.getRuntime().exec("dot -Tjpg -o "+filename+" "+filename+".dot") ;
    }

    private String lireFichier(String chemin_ficher) throws FileNotFoundException, IOException {
        contenu_fichier = new StringBuilder() ;
        f = new File(chemin_ficher) ;
        if(!f.getName().endsWith(".plic"))
            throw new ArrayIndexOutOfBoundsException() ;
        BufferedReader b = new BufferedReader(new FileReader(f)) ;
        String line = null ;
        while((line= b.readLine()) != null)
            contenu_fichier.append(line+"\n") ;
        return contenu_fichier.toString() ;
    }
    
    
    public static void main(String[] args) throws Exception {
        Test test = new Test(args);
    }

}
