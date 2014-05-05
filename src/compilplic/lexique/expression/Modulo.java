/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique.expression;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;
import java.util.Iterator;

/**
 *
 * @author Yan
 */
public class Modulo extends Binaire {

    public Modulo(Expression g, Expression d, int l, int c) {
        super(g, d, l, c);
    }
    
    @Override
    public Nombre calcul() {
        return new Nombre (gauche.calcul().toInt() + droite.calcul().toInt()) ;
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        super.verifier();
        if(gauche.isBoolean())
            throw new SemantiqueException("Expression gauche du modulo est booléenne, arithmétique attendue ligne:"+line+" colonne:"+col);
        
        if(droite.isBoolean())
            throw new SemantiqueException("Expression droite du modulo est booléenne, arithmétique attendue ligne:"+line+" colonne:"+col);
        
        //Pas de division par 0
        if(droite.isZero())
            throw new SemantiqueException("Division par 0 ligne:"+line+" colonne:"+col);
        
        return true;
    }

    @Override
    public String ecrireMips() {
        String str = gauche.ecrireMips();
        str+=droite.ecrireMips();
        str+=GenerateurMIPS.getInstance().ecrireModulo();
        
        return str;
    }
}
