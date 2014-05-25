/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique;

import compilplic.lexique.expression.Expression;

/**
 *
 * @author mick
 */
public class BoucleWhile extends Boucle {
    
    private Expression exp ;

    public BoucleWhile(Expression exp) {
        this.exp = exp;
    }
    
}
