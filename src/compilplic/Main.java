/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.exception.LexicalException;
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
            //System.out.println("args : "+args.length);
            if(args.length==1)
                plic = new Plic(args[0]);
            else
                plic = new Plic(args[0],args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage : L'extension du fichier source doit etre .plic");
        } catch (IOException e2) {
            System.err.println("IOException dans Main : fichier introuvable.");
        } catch (SemantiqueException e3) {
            System.err.println("ERREUR SEMANTIQUE : "+e3.getMessage()) ;
        } catch (LexicalException e4) {
            System.err.println("ERREUR LEXICALE : "+e4.getMessage()) ;
        } catch (Exception e5) {
            e5.printStackTrace();
            System.err.println("ERREUR SYNTAXIQUE : "+e5.getMessage()) ;
        }
    }
}
