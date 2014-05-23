 package compilplic.lexique;

import compilplic.generateur.GenerateurMIPS;


public class BlocIDF extends Bloc {
    
    protected String statut;
    protected String idf;
    
    public BlocIDF(String idf) {
        super();
        this.idf = idf;
    }

    @Override
    public String toString() {
        return super.toString()+" idf="+idf; 
    }
    
    @Override
    public boolean verifier() throws Exception {
       
        
        return true;
    }
    
    @Override
    public String ecrireMips() {
        String str = GenerateurMIPS.getInstance().ecrireBloc(idf);
        return str;
    }
}

