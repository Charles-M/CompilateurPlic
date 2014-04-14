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
        return new Nombre(1) ;
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
