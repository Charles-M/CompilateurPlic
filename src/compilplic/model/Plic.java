/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author mick
 */
public class Plic {
    
    private StringBuilder contenu_fichier ;

    public Plic(String chemin_ficher) throws IOException {
        contenu_fichier = new StringBuilder() ;
        //remplissage de la contenu_fichier avec le contenu du fichier pour eviter toute IO ulterieur.
        BufferedReader b = new BufferedReader(new FileReader(new File(chemin_ficher))) ;
        String line = b.readLine() ;
        while(line != null)
            contenu_fichier.append(line) ;
        System.out.println(contenu_fichier); // test
    }
    
}
