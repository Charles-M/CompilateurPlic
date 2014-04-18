/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.analyse.AnalyseurLexical;
import compilplic.lexique.expression.Expression;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 *
 * @author ASUS
 */
public class Test {

    public Test() throws IOException, Exception {
        String texte = "classe Test \"test_chaine\" \"test_chaine_guill\"\"emets\" publique privee entier lire et ecrire 31 / 45 - 78 fin/*coucou*/\n // yoyoyo\n4 /9" ;
        AnalyseurLexical a = new AnalyseurLexical(new StringReader(texte)) ;
        String token ;
        while(!(token=a.next_token().toString()).equals("#0"))
             System.out.println(token) ;
        
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
    
    
    public static void main(String[] args) throws Exception {
        Test test = new Test();
    }

}
