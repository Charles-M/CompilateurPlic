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
    
    /**
     * Permet de stocker directement un nombre dans la pile
     * @param i le nombre à stocker (entier)
     * @return le code Mips correspondant
     */
    public String ecrireNombre(int i){
        //Empile le nombre (Attention, pas de gestion du 32bit)
        String str="li $v0, "+i+"\n"
                +  "sw $v0, $(sp)\n"
                +  "add $sp, $sp, -4\n";
        
        return str;
    }
    
    /**
     * Permet de charger l'operande droite et l'operande gauche si ils sont dans la pile (et se suivent)
     * @return le code Mips associe
     */
    public String ecrireChargeOperandes(){
        //Chargement de l'opérande droite
        return "add $sp, $sp, 4\n"
                + "lw $v0, $(sp)\n"
                //Chargement de l'opérande gauche
                + "add $sp, $sp, 4\n"
                + "lw $t8, $(sp)\n"; 
    }
    
    /**
     * Permet de stocker dans la pile la valeur du registre v0
     * @return le code Mips associe
     */
    public String ecrireStocker(){
        //Stockage dans la pile
        return "sw $v0, $sp\n"
                + "add $sp, $sp, -4\n";
    }
    
    /**
     * Permet d'ecrire une somme
     * @return le code Mips associe
     */
    public String ecrireSomme(){
        //Exemple sans les méthodes ci-dessus
        //Chargement de l'opérande droite
        String str="add $sp, $sp, 4\n"
                + "lw $v0, $(sp)\n"
                //Chargement de l'opérande gauche
                + "add $sp, $sp, 4\n"
                + "lw $t8, $(sp)\n"
                //Ajout des deux (dans v0)
                + "add $v0, $t8, $v0\n"
                + "sw $v0, $sp\n"
                + "add $sp, $sp, -4\n";
        
        return str;
    }
    
    /**
     * Permet d'ecrire une soustraction
     * @return le code Mips associe
     */
    public String ecrireSoustraction(){
        
        //Chargement de l'opérande droite
        String str=ecrireChargeOperandes()
                //Soustraction des deux (dans v0)
                + "sub $v0, $t8, $v0\n"
                //Stockage dans la pile
                + ecrireStocker();
        
        return str;
    }
    
    /**
     * Permet d'ecrire une multiplication
     * @return le code Mips associe
     */
    public String ecrireMultiplication(){
        
        //Chargement de l'opérande droite
        String str=ecrireChargeOperandes()
                //Multiplication des deux (dans v0)
                + "mul $v0, $t8, $v0\n"
                //Stockage dans la pile
                + ecrireStocker();
        
        return str;
    }
    
    /**
     * Permet d'ecrire une division
     * @return le code Mips associe
     */
    public String ecrireDivision(){
        
        //Chargement de l'opérande droite
        String str=ecrireChargeOperandes()
                //Division des deux (dans v0)
                + "div $v0, $t8, $v0\n"
                //Stockage dans la pile
                + ecrireStocker();
        
        return str;
    }
    
    /**
     * Permet d'ecrire une comparaison plus grand que de type "v0 > t8" (avec branchement)
     * @return le code Mips associe
     */
    public String ecrireGreaterThan(){
        String str = 
                ecrireChargeOperandes()
                + "bgt $t8, $v0, greater\n";//Attention besoin de savoir le numéro de la branche
        
        return str;
    }
    
    /**
     * Permet d'ecrire une comparaison plus petit que de type "v0 < t8" (avec branchement)
     * @return le code Mips associe
     */
    public String ecrireLowerThan(){
        String str = 
                ecrireChargeOperandes()
                + "blt $t8, $v0, lower\n";//Attention besoin de savoir le numéro de la branche
        
        return str;
    }
    
    /**
     * Permet d'ecrire une comparaison egale de type "v0 == t8" (avec branchement)
     * @return le code Mips associe
     */
    public String ecrireEqual(){
        String str = 
                ecrireChargeOperandes()
                + "beq $t8, $v0, equal\n";//Attention besoin de savoir le numéro de la branche
        
        return str;
    }

    /**
     * Permet d'ecrire une comparaison differente de type "v0 != t8" (avec branchement)
     * @return le code Mips associe
     */
    public String ecrireNonEqual(){
        String str = 
                ecrireChargeOperandes()
                + "bne $t8, $v0, non_equal\n";//Attention besoin de savoir le numéro de la branche
        
        return str;
    }
}
