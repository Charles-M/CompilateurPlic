/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.analyse.AnalyseurLexical;
import compilplic.analyse.AnalyseurSyntaxique;
import compilplic.lexique.expression.Expression;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.corba.OutputStreamFactory;

/**
 *
 * @author ASUS
 */
public class Test {

    public Test() throws IOException {
        String expression = "5-3-1" ; // c'est pas encore bon...........
        AnalyseurSyntaxique as = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(expression)));
        try {
            Expression e = (Expression)as.parse().value ;
            System.out.println(e.ecrireMips());
            writeMips(e, "mips.asm");
            writeDot(e, "img.jpg");
            Runtime.getRuntime().exec("gedit mips.asm") ;
            Runtime.getRuntime().exec("eog img.jpg") ;
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    
    public static void main(String[] args) throws IOException {
        Test test = new Test();
    }

}
