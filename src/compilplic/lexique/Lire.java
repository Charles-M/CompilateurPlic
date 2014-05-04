package compilplic.lexique;

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
        String str = GenerateurMIPS.getInstance().lireEntier();
        return str;
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        System.out.println("Verif Lire\n");
        TDS tds = TDS.getInstance();
        Symbole s = tds.identifier(new Entree(value, line));
        if(s==null){
            throw new SemantiqueException("La declaration de la variable "+value+" a la ligne "+/*line+*/" est manquante");
        }
        return true;
    }

}

