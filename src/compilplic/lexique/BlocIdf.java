 package compilplic.lexique;


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
    public boolean verifier() throws Exception {
       
        
        return true;
    }
    
    @Override
    public abstract String ecrireMips();
}

