package compilplic.lexique;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;
import compilplic.tds.Entree;
import compilplic.tds.TDS;
import java.util.ArrayList;


/**
 * <!-- begin-user-doc -->
 * Classe Declaration de Constructeur
 * <!--  end-user-doc  -->
 * @generated
 */

public class D_Const extends Declaration
{
    /**
     * Liste des variable declaree
     */
    public ArrayList<Instruction> instruction;

    public D_Const(String idf, int line, ArrayList<Instruction> l) {
        super(idf, line);
        instruction = l ;
    }

    @Override
    public String toString() {
        return "D_Const{" + "instruction=" + instruction + '}';
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        System.out.println("Verif Const\n");
        return true;
    }

    @Override
    public String ecrireMips() {
        String str = GenerateurMIPS.getInstance().ecrireBloc(idf);
        for(Instruction i : instruction){
            str += i.ecrireMips();
        }
        return str;
    }

}

