/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.lexique.expression;

import compilplic.generateur.GenerateurMIPS;

/**
 *
 * @author ASUS
 */
public class LowerThan extends Binaire {

    public LowerThan(Expression g, Expression d) {
        super(g, d);
    }

    @Override
    public Nombre calcul() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifier() {
        
        return gauche.verifier() && droite.verifier();
        
    }

    @Override
    public String ecrireMips() {
        String str = GenerateurMIPS.getInstance().ecrireLowerThan();
        
        return str;
    }
    
    @Override
    public boolean isBoolean(){
        return true;
    }
    
}
