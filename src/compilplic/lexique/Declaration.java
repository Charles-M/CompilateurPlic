package compilplic.lexique;


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
	
	public Bloc bloc;

    public Declaration(String idf, int line) {
        this.idf = idf;
        this.line = line;
    }
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String ecrireMips() {
		// TODO : to implement
		return "";	
	}

    @Override
    public String toString() {
        return "Declaration{" + "idf=" + idf + ", line=" + line + '}';
    }
        
        
	
}

