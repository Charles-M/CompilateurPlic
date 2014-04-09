/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.lexique;

import compilplic.lexique.expression.Expression;

/**
 * Noeud de l'arbre qui devra ecrire le code mips d'une evalution d'expression, entre autre celle qu'il connait
 * @author ASUS
 */
public class EvaluationExpr extends Instruction {

    private Expression e ;
    
    public EvaluationExpr() {
    }

    @Override
    public String ecrire() {
        e.ecrireMips() ;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
