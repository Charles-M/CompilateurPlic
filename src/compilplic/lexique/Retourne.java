/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import compilplic.lexique.expression.Expression;
import compilplic.lexique.expression.Identificateur;
import compilplic.tds.Entree;
import compilplic.tds.Region;
import compilplic.tds.Symbole;
import compilplic.tds.TDS;

/**
 *
 * @author ASUS
 */
public class Retourne extends Instruction {

    private Expression exp ;
    private String type;
    
    public Retourne(int line, Expression e) {
        super(line);
        exp = e ;
        type="entier";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Retourne{" + "exp=" + exp + '}';
    }

    @Override
    public String ecrireMips() {
        return exp.ecrireMips();
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        if(!exp.verifier())
            GestionnaireSemantique.getInstance().add(new SemantiqueException("ligne "+line+": La variable de retour "+((Identificateur) exp).getNom()+" n'est pas declaree"));
        
        if(exp.isBoolean())
            GestionnaireSemantique.getInstance().add(new SemantiqueException("ligne "+line+": type de retour trouve : booleen, entier ou objet attendu"));
        
        if(exp instanceof Identificateur){
            Identificateur i = (Identificateur) exp;
            Symbole s = TDS.getInstance().identifier(new Region(this.numBloc,0,null),new Entree(i.getNom(), 0, "variable"));
            type = s.getType();
        }
        
        return true;
    }
    
}
