/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.lexique.expression;

/**
 *
 * @author ASUS
 */
public class GreaterThan extends Binaire {

    public GreaterThan(Expression g, Expression d) {
        super(g, d);
    }

    public Nombre calcul() {
        return new Nombre(null) ;
    }
    
}
