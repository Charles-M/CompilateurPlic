/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique;

import compilplic.lexique.expression.Expression;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public abstract class Boucle extends Bloc {

    protected Expression expression ;
    protected ArrayList<Instruction> instructions;
    
    public Boucle(Expression exp){
        expression = exp;
    }
    
}
