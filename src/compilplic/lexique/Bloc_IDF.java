 package compilplic.lexique;




public class Bloc_IDF extends Bloc {
    
    protected String statut;
    protected String idf;
    
    public Bloc_IDF(String idf) {
        super();
        this.idf = idf;
    }

    @Override
    public String toString() {
        return super.toString()+" idf="+idf+" l_decl="+declaration; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean verifier() throws Exception {
        super.verifier();
        
        return true;
    }
    
    @Override
    public String ecrireMips() {
        String str =""/*= GenerateurMIPS.getInstance().ecrireBloc(idf+this.hashCode())*/;
        str+=super.ecrireMips();
        return str;
    }
}

