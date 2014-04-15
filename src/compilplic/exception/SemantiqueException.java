/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.exception;

/**
 *
 * @author charles9u
 */
public class SemantiqueException extends Exception {

    public SemantiqueException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage(); 
    }
    
}
