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
public class Equal extends Binaire {

    public Equal(Expression g, Expression d) {
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
        String str = GenerateurMIPS.getInstance().ecrireEqual();
        
        return str;
    }
    
    @Override
    public boolean isBoolean(){
        return true;
    }
    
}
