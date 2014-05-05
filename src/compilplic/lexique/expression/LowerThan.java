/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.lexique.expression;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;

/**
 *
 * @author ASUS
 */
public class LowerThan extends Binaire {

    public LowerThan(Expression g, Expression d, int l, int c) {
        super(g, d, l, c);
    }

    @Override
    public Nombre calcul() {
        return new Nombre(1) ;
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        
        return super.verifier();
        
    }

    @Override
    public String ecrireMips() {
        String str = gauche.ecrireMips();
        str+=droite.ecrireMips();
        str+= GenerateurMIPS.getInstance().ecrireLowerThan(this.hashCode());
        
        return str;
    }
    
    @Override
    public boolean isBoolean(){
        return true;
    }
    
}
