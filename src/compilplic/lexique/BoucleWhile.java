/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import compilplic.lexique.expression.Expression;

/**
 *
 * @author mick
 */
public class BoucleWhile extends Boucle {

    public BoucleWhile(Expression exp) {
        super(exp);
        expression = exp;
    }

    @Override
    public boolean verifier() throws Exception {
        expression.verifier();
        if(!expression.isBoolean())
            GestionnaireSemantique.getInstance().add(new SemantiqueException("Expression arithmétique trouvée, expression booléenne attendue"));
        for (Instruction i : instructions) {
            i.verifier();
        }
        return true;
    }

    @Override
    public String ecrireMips() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
