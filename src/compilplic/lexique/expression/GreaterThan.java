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

    public GreaterThan(Expression g, Expression d) {
        super(g, d);
    }

    public Nombre calcul() {
        return new Nombre(null) ;
    }
    
    public String ecrireMips(){
        String str = GenerateurMIPS.getInstance().ecrireGreaterThan();
        
        return str;
    }
    
}
