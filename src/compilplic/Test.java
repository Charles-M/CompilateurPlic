/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.analyse.AnalyseurLexical;
import compilplic.analyse.AnalyseurSyntaxique;
import compilplic.lexique.expression.Expression;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Test {

    public Test() throws IOException {
        //String expression = "((((17*3)*4)+2)-4)*(-78+(5-7*(2)))" ; // C'EST BON !!!
        String expression = "((4*5)<50)*((3<(25+6))*(58>(96-50)))";
        //String expression = "(4*5)<50*3";
        AnalyseurSyntaxique as = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(expression)));
        try {
            Expression e = (Expression)as.parse().value ;
            e.verifier();
            System.out.println(e.ecrireMips());
            writeMips(e, "mips.asm");
            writeDot(e, "img.jpg");
            // Runtime.getRuntime().exec("gedit mips.asm") ;
            //Runtime.getRuntime().exec("eog img.jpg") ;
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
