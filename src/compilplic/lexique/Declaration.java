package compilplic.lexique;

import compilplic.exception.SemantiqueException;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class Declaration
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected String idf;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected int line;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Bloc_IDF bloc;

    public Declaration(String idf, int line) {
        this.idf = idf;
        this.line = line;
    }

    @Override
    public String toString() {
        return "Declaration{" + "idf=" + idf + ", line=" + line + '}';
    }
        
    public abstract boolean verifier() throws SemantiqueException;
    
    public abstract String ecrireMips();
	
}

