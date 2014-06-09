/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import compilplic.lexique.expression.Expression;
import compilplic.tds.Entree;
import compilplic.tds.Region;
import compilplic.tds.Symbole;
import compilplic.tds.TDS;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Instantiation extends Instruction {

    private ArrayList<Expression> liste_param ;
    private String idf, classe ;
    
    public Instantiation(int line, String idf, String type, ArrayList<Expression> l) {
        super(line);
        this.idf = idf ;
        classe = type ;
        liste_param = l ;
    }

    @Override
    public String ecrireMips() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        TDS tds = TDS.getInstance();
        
        Symbole sv = tds.identifier(new Region(this.numBloc,0,null),new Entree(idf, 0, "variable"));
        
        if(sv==null)
            GestionnaireSemantique.getInstance().add(new SemantiqueException("ligne "+line+" : la variable "+idf+" n'est pas declare"));
        
        
        Symbole scl = tds.identifier(new Region(this.numBloc,0,null),new Entree(classe, 0, "classe"));
        
        if(scl==null)
            GestionnaireSemantique.getInstance().add(new SemantiqueException("ligne "+line+" : la classe "+classe+" n'est pas declaree"));
        
        if(!sv.getType().equals(scl.getType()))
            GestionnaireSemantique.getInstance().add(new SemantiqueException("ligne "+line+" : affectation de types incompatibles : d'un objet "+classe+" dans une variable de type "+sv.getType()));
        
        return true;
    }
    
}
