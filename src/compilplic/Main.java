/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.model.Plic;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mick
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            Plic plic;
            plic = new Plic(args[0]);
        } catch (IOException e) {
            System.err.println("IOException dans Main : fichier introuvable.");
        } catch (Exception ex) {
            System.err.println("exception de l'analyseur");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
