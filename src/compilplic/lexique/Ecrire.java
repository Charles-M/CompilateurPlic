package compilplic.lexique;


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
	
	public Object value;

    public Ecrire(Object value, int line) {
        super(line);
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString()+" expr="+value; //To change body of generated methods, choose Tools | Templates.
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

