/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.exception;
import compilplic.tds.Entree;


/**
 *
 * @author Yan
 */
public class DoubleDeclarationException extends SemantiqueException {

    public DoubleDeclarationException(Entree e, String s) {
        super(""+e.toString());
    }
    
}
