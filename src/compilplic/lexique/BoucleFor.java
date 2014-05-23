package compilplic.lexique;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import compilplic.lexique.expression.Expression;
import compilplic.lexique.expression.Identificateur;
import java.util.ArrayList;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class BoucleFor extends Bloc
{

    private Expression expression;
    public ArrayList<Instruction> instructions;
    
    public BoucleFor() {
        super();
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifier() throws Exception {
        if(!expression.verifier())
            GestionnaireSemantique.getInstance().add(new SemantiqueException("La declaration de la variable "+((Identificateur) expression).getNom()+" a la ligne "+/*line+*/" est manquante"));
                
        for(Instruction i : instructions){
            i.verifier();
        }
        return true;
    }
    
    @Override
    public String ecrireMips(){
        String str = "";
        for(Instruction i : instructions){
            str += i.ecrireMips();
        }
        
        return str;
    }
    
}

