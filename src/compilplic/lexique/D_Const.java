package compilplic.lexique;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;
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
        for(Instruction i : instruction){
            i.verifier();
        }
        return true;
    }

    @Override
    public String ecrireMips() {
        String str = GenerateurMIPS.getInstance().ecrireBloc("Constructeur_"+idf+hashCode());
        for(Instruction i : instruction){
            str += i.ecrireMips();
        }
        return str;
    }
}

