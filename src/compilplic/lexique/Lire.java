package compilplic.lexique;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;
import compilplic.tds.Entree;
import compilplic.tds.Symbole;
import compilplic.tds.TDS;


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
        TDS tds = TDS.getInstance();
        Symbole s = tds.identifier(new Entree(value, 0));

        String str = GenerateurMIPS.getInstance().lireEntier(s.getDeplacement(),s.isGlobal());
        return str;
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        TDS tds = TDS.getInstance();
        Symbole s = tds.identifier(new Entree(value, 0));
        if(s==null){
            GestionnaireSemantique.getInstance().add(new SemantiqueException("La declaration de la variable "+value+" a la ligne "+/*line+*/" est manquante"));
        }
        return true;
    }

}

