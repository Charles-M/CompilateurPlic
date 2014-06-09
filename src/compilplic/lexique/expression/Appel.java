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
import compilplic.tds.Region;
import compilplic.tds.Symbole;
import compilplic.tds.TDS;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ASUS
 */
public class Appel extends Expression {

    private String nom_fonction ;
    private ArrayList<Expression> liste_param ;
    protected int line;
    protected int numBloc;

    public Appel(String nom_fonction, ArrayList<Expression> liste_param, int l) {
        this.nom_fonction = nom_fonction;
        this.liste_param = liste_param;
        line=l;
    }
    
    @Override
    public Nombre calcul() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbrOperande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbrNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Nombre> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nombre nbri(int compteur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        TDS tds = TDS.getInstance();
        ArrayList<String> array = new ArrayList<>();
        for(Expression expression : this.liste_param) {
            if(!expression.verifier())
                GestionnaireSemantique.getInstance().add(new SemantiqueException("La declaration de la variable "+((Identificateur) expression).getNom()+" a la ligne "+line+" est manquante"));
            
        }
        
        Symbole s = tds.identifier(new Region(this.numBloc,0,null),new Entree(nom_fonction,0,"function"));
        if(s==null)
            GestionnaireSemantique.getInstance().add(new SemantiqueException("la fonction "+nom_fonction+"n'a pas été déclarée"));
        return true;
    }

    @Override
    public String ecrireMips() {
        TDS tds = TDS.getInstance();
        Entree e = new Entree(nom_fonction,0,"fonction");
        Symbole s = tds.identifier(new Region(this.numBloc,0,null),e);
        Region r = tds.getRegionFromEntree(e, nom_fonction);
        return GenerateurMIPS.getInstance().ecrireChargeEnvironnement(r.getBloc(),s.getDeplacement());
    }

    @Override
    public String ecrireDot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
