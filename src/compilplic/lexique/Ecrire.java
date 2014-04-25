package compilplic.lexique;
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
    public String toString() {
        return super.toString()+" expr="+expression; //To change body of generated methods, choose Tools | Templates.
    }
        
        

}

