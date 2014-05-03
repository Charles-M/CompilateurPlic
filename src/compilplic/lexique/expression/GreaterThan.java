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
public class GreaterThan extends Binaire {

    public GreaterThan(Expression g, Expression d, int l, int c) {
        super(g, d, l, c);
    }

    public Nombre calcul() {
        return new Nombre(null) ;
    }
    
    public String ecrireMips(){
        String str = gauche.ecrireMips();
        str+=droite.ecrireMips();
        str+=GenerateurMIPS.getInstance().ecrireGreaterThan(this.hashCode())+"\n";
        
        return str;
    }

    @Override
    public boolean verifier() throws Exception {
        
        return super.verifier();
        
    }
    
    @Override
    public boolean isBoolean(){
        return true;
    }
    
}
