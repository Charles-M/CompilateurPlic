package compilplic.lexique;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;
import compilplic.tds.Entree;
import compilplic.tds.Symbole;
import compilplic.tds.TDS;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Classe extends Bloc_IDF
{

    public Classe(String idf) {
        super(idf);
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean verifier() throws Exception{
        super.verifier();
        return true;
    }
    
    @Override
    public String ecrireMips(){
        String str=GenerateurMIPS.getInstance().ecrireBloc("Class_"+idf);
        str+=super.ecrireMips();
        return str;
    }

}

