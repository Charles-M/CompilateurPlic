package compilplic.lexique;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;


/**
 * <!-- begin-user-doc -->
 * Classe Declaration de Champ
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

    @Override
    public boolean verifier() throws SemantiqueException {
        /*TDS tds = TDS.getInstance();
        String type = tds.identifier(idf);
        if(type==null)
            GestionnaireSemantique.getInstance().add(new SemantiqueException("Variable "+idf+" non declaree"));
        if(!type.equals("entier"))
            GestionnaireSemantique.getInstance().add(new SemantiqueException("Variable "+idf+" pas de type entier"));*/
        return true;
    }

    @Override
    public String ecrireMips() {
        return GenerateurMIPS.getInstance().ecrireAjouterChamp();
    }
	
        

}

