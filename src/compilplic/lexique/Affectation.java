package compilplic.lexique;
import compilplic.lexique.expression.Expression;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Affectation extends Instruction
{
	
	public Expression expression;
	
        

    @Override
    public String toString() {
        return super.toString()+" expr="+expression ; //To change body of generated methods, choose Tools | Templates.
    }

        
}

