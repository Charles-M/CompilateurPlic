package compilplic.lexique;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import java.util.ArrayList;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Function extends BlocIdfParam
{
    
    protected String type_retour;
    public ArrayList<Instruction> instructions;
    
    public Function() {
        super(null);
    }

    public void setIdf(String idf) {
        this.idf = idf;
    }

    public void setType_retour(String type_retour) {
        this.type_retour = type_retour;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Function{" + "type_retour=" + type_retour + ", instructions=" + instructions + '}';
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

