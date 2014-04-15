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

    public Plic(String chemin_ficher) throws IOException, Exception {
        lireFichier(chemin_ficher) ;
        AnalyseurSyntaxique as = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(contenu_fichier.toString())));
        Expression e = (Expression)as.parse().value ;
        e.verifier();
        writeMips(e, f.getAbsolutePath());
    }
    
    private void writeMips(Expression e, String filename) throws IOException {
        String s = e.ecrireMips() ;
        PrintWriter mips = new PrintWriter(new File(filename.replaceAll("\\.plic", ".asm"))) ;
        mips.printf(s);
        mips.close();
    }

    private void lireFichier(String chemin_ficher) throws FileNotFoundException, IOException {
        contenu_fichier = new StringBuilder() ;
        f = new File(chemin_ficher) ;
        BufferedReader b = new BufferedReader(new FileReader(f)) ;
        String line = null ;
        while((line= b.readLine()) != null)
            contenu_fichier.append(line) ;
    }
}
