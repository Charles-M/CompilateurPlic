/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.analyse.AnalyseurLexical;
import compilplic.analyse.AnalyseurSyntaxique;
import compilplic.lexique.Lexique;
import compilplic.lexique.expression.Expression;
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
        AnalyseurSyntaxique s = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(texte))) ;
        Lexique l = (Lexique) s.parse().value ;
        System.out.println("lexique = \n"+l);
        System.out.println("FINI !");
    }
    
    private void writeMips(Expression e, String filename) throws IOException {
        String s = e.ecrireMips() ;
        PrintWriter mips = new PrintWriter(new File(filename)) ;
        mips.printf(s);
        mips.close();
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
