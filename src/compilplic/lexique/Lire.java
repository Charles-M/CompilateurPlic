package compilplic.lexique;

import compilplic.generateur.GenerateurMIPS;


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
        
        

    @Override
    public String ecrireMips() {
        String str = GenerateurMIPS.getInstance().lireEntier();
        
        return str;
    }

    @Override
    public boolean verifier() {
        return true;
    }

}

