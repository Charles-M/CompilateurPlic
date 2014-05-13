/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.exception;

import java.util.ArrayList;

/**
 *
 * @author charles9u
 */
public class GestionnaireSemantique extends ArrayList<SemantiqueException> {

    private static GestionnaireSemantique instance ;
    
    public static GestionnaireSemantique getInstance() {
        if(instance == null)
            instance = new GestionnaireSemantique() ;
        return instance ;
    }
    
}
