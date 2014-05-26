/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique;

import compilplic.exception.SemantiqueException;
import compilplic.lexique.expression.Expression;

/**
 *
 * @author ASUS
 */
public class Retourne extends Instruction {

    private Expression exp ;
    
    public Retourne(int line, Expression e) {
        super(line);
        exp = e ;
    }

    @Override
    public String toString() {
        return "Retourne{" + "exp=" + exp + '}';
    }

    @Override
    public String ecrireMips() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
