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

public class Conditionnelle extends Bloc
{

    private Expression expression;
    public ArrayList<Instruction> instructions;
        
    public Conditionnelle() {
        super();
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public boolean verifier() throws Exception {
        super.verifier();
        if(!expression.verifier())
            GestionnaireSemantique.getInstance().add(new SemantiqueException("La declaration de la variable "+((Identificateur) expression).getNom()+" a la ligne "+/*line+*/" est manquante"));
        if(!expression.isBoolean())
            GestionnaireSemantique.getInstance().add(new SemantiqueException("Expression entiere trouvee a la ligne "/*+line*/+", expression booleenne attendue"));
        
        for(Instruction i : instructions){
            i.verifier();
        }
        return true;
    }
    
    public String ecrireMIPS(){
        String str = "";
        
        for(Instruction i : instructions){
            str += i.ecrireMips();
        }
        
        return str;
    }

}

