/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique;

import compilplic.generateur.GenerateurMIPS;
import compilplic.tds.Entree;
import compilplic.tds.Symbole;
import compilplic.tds.TDS;
import java.util.ArrayList;

/**
 *
 * @author Yan
 */
public class Bloc {
    
    public Lexique lexique;
    public ArrayList<Declaration> declaration;

    public Bloc() {
        declaration = new ArrayList<>() ;
    }

    void ajouterDecl(Declaration d) {
        declaration.add(d) ;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    public boolean verifier() throws Exception {
        for(Declaration d : declaration){
            d.verifier();
        }

        return true;
    }
    
    public String ecrireMips() {
        String str = "";
        TDS tds = TDS.getInstance();
        for(Declaration d : declaration){
            if(d instanceof D_Champ){
                Symbole s = tds.identifier(new Entree(((D_Champ) d).idf));
                if(s.isGlobal()){
                    str+=d.ecrireMips();
                }
            }
        }
        for(Declaration d : declaration){
            if(d instanceof D_Champ){
                Symbole s = tds.identifier(new Entree(((D_Champ) d).idf));
                if(!s.isGlobal()){
                    str+=d.ecrireMips();
                }
            }else
                str+=d.ecrireMips();
        }

        return str;
    }
}
