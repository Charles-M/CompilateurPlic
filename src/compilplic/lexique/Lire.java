package compilplic.lexique;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Lire extends Instruction
{
	private String value ;

    public Lire(String value, int line) {
        super(line);
        this.value = value;
    }

    @Override
    public String toString() {
        return "Lire{" + "value=" + value + '}';
    }
        
        

}

