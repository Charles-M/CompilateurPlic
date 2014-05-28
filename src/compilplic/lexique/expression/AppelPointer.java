/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique.expression;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;
import compilplic.tds.Entree;
import compilplic.tds.Symbole;
import compilplic.tds.TDS;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class AppelPointer extends Appel {
    
    private String objet ;    

    public AppelPointer(String objet, String nom_fonction, ArrayList<Expression> liste_param, int l) {
        super(nom_fonction, liste_param, l);
        this.objet = objet;
    }
    
    @Override
    public boolean verifier() throws SemantiqueException{
        TDS tds = TDS.getInstance();
        Symbole s = tds.identifier(new Entree(objet, 0, "variable"));
        if(s==null)
            GestionnaireSemantique.getInstance().add(new SemantiqueException("ligne "+0+" : L'objet "+objet+" n'a pas été déclaré"));
        super.verifier();
        return true;
    }
    
    @Override
    public String ecrireMips(){
        TDS tds = TDS.getInstance();
        Symbole s = tds.identifier(new Entree(objet, 0, "variable"));
        return GenerateurMIPS.getInstance().ecrireAppelPointer(s.getDeplacement())+super.ecrireMips();
    }
}
