/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.analyse.AnalyseurLexical;
import compilplic.analyse.AnalyseurSyntaxique;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Test {

    public Test() throws IOException {
        String expression = "12 + 3-(   -078 * (1+666))" ;
        AnalyseurSyntaxique as = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(expression)));
        try {
            as.parse() ;
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws IOException {
        Test test = new Test();
    }

}