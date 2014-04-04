/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.model.Plic;
import java.io.IOException;

/**
 * @author mick
 */
public class Main {

    public static void main(String[] args) {
        try {
            // j'voulais mettre simplement : new Plic() ; mais netbeans il dit c'est mieux de faire 2 lignes, pour utiliser plus de caractère, -_-"
            Plic p ;
            p = new Plic(args[0]);
        } catch (IOException e) {
            System.out.println("IOException dans Main : fichier introuvable ou corrompue ou je sais pas.");
        }
    }
}
