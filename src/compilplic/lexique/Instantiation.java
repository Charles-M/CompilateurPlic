/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique;

import compilplic.exception.SemantiqueException;
import compilplic.lexique.expression.Expression;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
