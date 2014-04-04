/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.generateur;

import java.io.PrintStream;

/**
 * Cette classe est une collection de string representative du langage MIPS
 * @author ASUS
 */
public final class GenerateurMIPS {
    
    private static GenerateurMIPS instance ;
    private static PrintStream f; // peut etre pas utile, a discuter
     // j'ai mis n'imp, a reflechir, %s est parametrable avec un printf ;)
    private String affectation = "lw $v0, (%s)$sp\n ... " ;
    private String bloc_if = "if%s evaluation expression, banchement etc..." ;
    
    public static GenerateurMIPS getInstance(){
        if(instance == null)
            instance = new GenerateurMIPS() ;
        return instance ;
    }
    
    public String ecrireAffectation(String deplacementVariable){
        // si on demande au generateur d'ecrire le .mips
        f.printf(affectation, deplacementVariable);
        // si on fait ecrire le fichier par une classe qui appel ces string
        String format = String.format(affectation, deplacementVariable);
        return format ;
    }
}
