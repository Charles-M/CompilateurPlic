/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.exception.SemantiqueException;
import compilplic.model.Plic;
import java.io.IOException;

/**
 * @author mick
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            Plic plic;
            plic = new Plic(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage : plic chemin_fichier_plic");
        } catch (IOException e2) {
            System.err.println("IOException dans Main : fichier introuvable.");
        } catch (SemantiqueException e3) {
            System.err.println("ERREUR SEMANTIQUE : "+e3.getMessage()) ;
        } catch (Exception e4) {
            System.err.println("ERREUR SYNTAXIQUE : "+e4.getMessage()) ;
        }
    }
}
