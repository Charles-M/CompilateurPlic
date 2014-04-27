package compilplic.lexique;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class D_Champ extends Declaration
{
	
	private String statut;
	
	private String type;

    public D_Champ(String idf, int line, String statut, String type) {
        super(idf, line);
        this.statut = statut ;
        this.type = type ;
    }

    @Override
    public String toString() {
        return "D_Champ{" + "statut=" + statut + ", type=" + type + ", idf="+idf+'}';
    }
	
        

}

