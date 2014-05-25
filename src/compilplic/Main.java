/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.exception.LexicalException;
import compilplic.model.Plic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author mick
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            Plic plic;
            String chemin_src = args[0] ;
            if(args.length==1)
                plic = new Plic(args);
            else
                plic = new Plic(chemin_src,args[1]);
            InputStream out = Runtime.getRuntime().exec("java -jar Mars4_4.jar "+args[0].replace(".plic", ".asm")).getInputStream() ;
            BufferedReader buf = new BufferedReader(new InputStreamReader(out)) ;
            String line = null ;
            while((line = buf.readLine()) != null)
                System.out.println(line);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage : L'extension du fichier source doit etre .plic");
        } catch (IOException e2) {
            System.err.println("Fichier introuvable.");
        } catch (LexicalException e4) {
            System.err.println("ERREUR LEXICALE : "+e4.getMessage()) ;
        } catch (Exception e5) {
            e5.printStackTrace();
            System.err.println("ERREUR SYNTAXIQUE : "+e5.getMessage()) ;
        }
    }
}
