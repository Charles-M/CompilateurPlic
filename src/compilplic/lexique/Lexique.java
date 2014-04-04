/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.lexique;

import java.util.ArrayList;

/**
 * Le fameux arbre qu'il faudrait faire faire par l'analyseur syntaxique, et decorer par le sémantique
 * @author ASUS
 */
public class Lexique {
    
    /**
     * Le lexique parcourira cette liste en appelant la methode ecrire() de chaque element, 
     * qui ecriront l'instruction plic qu'il represente (en mips) dans le fichier mips grace au GenerateurMIPS
     */
    private ArrayList<Instruction> listeInstruction ;

    public Lexique() {
        listeInstruction = new ArrayList<Instruction>() ;
    }
    
}
