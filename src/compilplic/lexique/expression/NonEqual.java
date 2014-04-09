/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.lexique.expression;

/**
 *
 * @author ASUS
 */
public class NonEqual extends Binaire {

    public NonEqual(Expression g, Expression d) {
        super(g, d);
    }

    @Override
    public Nombre calcul() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
