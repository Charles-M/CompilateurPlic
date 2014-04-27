package compilplic.lexique;

import compilplic.generateur.GenerateurMIPS;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Lire extends Instruction
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Lire(){
		super();
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

