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

public class Constructeur extends BlocIdfParam
{
    /**
     * Liste des variable declaree
     */
    public ArrayList<Instruction> instructions;

    public Constructeur() {
        super("constructeur");
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void setIdf(String idf) {
        this.idf = idf;
    }

    @Override
    public String toString() {
        return "Constructeur{" + "instructions=" + instructions + '}';
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        super.verifier();
        for(Instruction i : instructions){
            i.numBloc=this.getNumBloc();
            i.verifier();
        }
        return true;
    }

    @Override
    public String ecrireMips() {
        String str = GenerateurMIPS.getInstance().ecrireBloc("Constructeur_"+idf+liste_param.toString());
        for(Instruction i : instructions){
            str += i.ecrireMips();
        }
        return str;
    }
}

