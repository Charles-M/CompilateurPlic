package compilplic.lexique;
import compilplic.generateur.GenerateurMIPS;
import compilplic.lexique.expression.Expression;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Ecrire extends Instruction
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Expression expression;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Ecrire(){
		super();
	}

    @Override
    public String ecrireMips() {
        String str = GenerateurMIPS.getInstance().ecrireEntier();
        
        return str;
    }

    @Override
    public boolean verifier() throws Exception {
        expression.verifier();
        return true;
    }

}

