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
public class NonEqual extends Binaire {

    public NonEqual(Expression g, Expression d, int l, int c) {
        super(g, d, l, c);
    }

    @Override
    public Nombre calcul() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifier() throws Exception {
        
        return super.verifier();
        
    }

    @Override
    public String ecrireMips() {
        String str = gauche.ecrireMips();
        str+=droite.ecrireMips();
        str+= GenerateurMIPS.getInstance().ecrireNonEqual(this.hashCode());
        
        return str;
    }
    
    @Override
    public boolean isBoolean(){
        return true;
    }

}
