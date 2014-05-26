package compilplic.lexique;

import compilplic.exception.SemantiqueException;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class Instruction
{
    
    protected int line ;

    public Instruction(int line) {
        this.line = line;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     * @generated
     * @ordered
     */
    public abstract String ecrireMips() ;

    public abstract boolean verifier() throws SemantiqueException ;
}

