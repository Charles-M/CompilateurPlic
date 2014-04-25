package compilplic.lexique;

import java.util.ArrayList;




public class Bloc {
    
    protected String idf;
    public Lexique lexique;
    public ArrayList<Declaration> declaration;

    public Bloc(String idf) {
        this.idf = idf;
        declaration = new ArrayList<>() ;
    }

    
    public String ecrireMips() {
            // TODO : to implement
            return "";	
    }

    void ajouterDecl(Declaration d) {
        declaration.add(d) ;
    }

    @Override
    public String toString() {
        return super.toString()+" idf="+idf+" l_decl="+declaration; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

