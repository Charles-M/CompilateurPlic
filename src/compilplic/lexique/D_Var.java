/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique;

import compilplic.exception.SemantiqueException;

/**
 *
 * @author ASUS
 */
public class D_Var extends Declaration {

    
	private String type;
        
    public D_Var(String idf, int line, String type) {
        super(idf, line);
        this.type = type ;
    }

    @Override
    public String toString() {
        return "D_Var{" + "type=" + type + " idf=" + idf + '}';
    }

    
    @Override
    public boolean verifier() throws SemantiqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ecrireMips() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
