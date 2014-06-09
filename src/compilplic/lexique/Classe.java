package compilplic.lexique;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;

public class Classe extends BlocIdf
{
    
    public Classe(String idf) {
        super(idf);
    }

    @Override
    public String toString() {
        return "Classe{" +idf+ '}';
    }
    
    @Override
    public boolean verifier() throws SemantiqueException{
        super.verifier();
        return true;
    }
    
    @Override
    public String ecrireMips(){
        String str=GenerateurMIPS.getInstance().ecrireBloc("Class_"+idf);
        return str;
    }

}

