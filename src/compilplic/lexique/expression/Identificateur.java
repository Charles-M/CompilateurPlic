/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique.expression;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;
import compilplic.tds.Entree;
import compilplic.tds.Symbole;
import compilplic.tds.TDS;
import java.util.Iterator;

/**
 *
 * @author ASUS
 */
public class Identificateur extends Expression{

    private String nom ;

    public Identificateur(String nom) {
        this.nom = nom;
    }
    
    @Override
    public Nombre calcul() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNom() {
        return nom;
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
    public boolean verifier() throws Exception {
        TDS tds = TDS.getInstance();
        Symbole decl = tds.identifier(new Entree(getNom()));
        if(decl==null)
            System.err.println("VERIF Declaration de "+this.nom+" introuvable");
        if(decl==null)
            return false;
        
        return true;
    }

    @Override
    public String ecrireMips() {
        TDS tds = TDS.getInstance();
        Symbole decl = tds.identifier(new Entree(getNom()));
        if(decl==null)
            System.err.println("MIPS Declaration de "+this.nom+" introuvable");
        return GenerateurMIPS.getInstance().ecrireIdentificateur(/*tds.getDeplacement()+*/decl.getDeplacement());
    }

    @Override
    public String ecrireDot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
