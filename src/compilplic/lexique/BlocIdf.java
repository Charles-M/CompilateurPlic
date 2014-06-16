 package compilplic.lexique;

import compilplic.exception.SemantiqueException;


public abstract class BlocIdf extends Bloc {
    
    protected String statut;
    protected String idf;
    
    public BlocIdf(String idf) {
        super();
        this.idf = idf;
    }

    @Override
    public String toString() {
        return super.toString()+" idf="+idf; 
    }
    
    @Override
    public boolean verifier() throws SemantiqueException {
       
        
        return true;
    }
    
    @Override
    public abstract String ecrireMips();
}

