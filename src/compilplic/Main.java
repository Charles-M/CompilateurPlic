/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic;

import compilplic.exception.LexicalException;
import compilplic.exception.SyntaxeException;
import compilplic.model.Plic;
import java.io.BufferedReader;
import java.io.File;
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
            switch(args.length){
                case 2:
                    testArgs(args[0]);
                    plic = new Plic(args[0],args[1]);
                    break;
                case 3:
                    testArgs(args[0]);
                    plic = new Plic(args[0],args[2],args[1]);
                    break;
                default:
                    throw new ArrayIndexOutOfBoundsException("USAGE : plic fichier_source.plic classe_main [fichier_destination.asm]");
            } 
            InputStream out = Runtime.getRuntime().exec("java -jar Mars4_4.jar "+args[0].replace(".plic", ".asm")).getInputStream() ;
            BufferedReader buf = new BufferedReader(new InputStreamReader(out)) ;
            String line = null ;
            while((line = buf.readLine()) != null)
                System.out.println(line);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.err.println("ERREUR ARGUMENTS : "+aioobe.getMessage());
        }catch(IOException io){
            System.err.println("ERREUR FICHIER SOURCE : "+io.getMessage());
        } catch (LexicalException le) {
            System.err.println("ERREUR LEXICALE : "+le.getMessage()) ;
        } catch (SyntaxeException se) {
            System.err.println("ERREUR SYNTAXIQUE : "+se.getMessage()) ;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void testArgs(String path) throws IOException {
        File f = new File(path);
        if(!f.exists() || f.isDirectory())
            throw new IOException("Fichier source introuvable");
    }
}
