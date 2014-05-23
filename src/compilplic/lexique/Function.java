package compilplic.lexique;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import java.util.ArrayList;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Function extends BlocIDF
{
    
    protected String type_retour;
    public ArrayList<Instruction> instructions;
    
    public Function(String idf, String type) {
        super(idf);
        type_retour=type;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean verifier() throws Exception{
        super.verifier();
        if(!type_retour.equals("entier"))
            GestionnaireSemantique.getInstance().add(new SemantiqueException("Le type de retour de la fonction "+idf+" est de type "+type_retour+", type entier attendu"));
                
        for(Instruction i : instructions){
            i.verifier();
        }
        return true;
    }
    
    @Override
    public String ecrireMips(){
        String str = super.ecrireMips();
                
        for(Instruction i : instructions){
            str += i.ecrireMips();
        }
        
        return str;
    }

}

