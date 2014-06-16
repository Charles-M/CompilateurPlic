package compilplic.lexique;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;
import compilplic.tds.Entree;
import compilplic.tds.Region;
import compilplic.tds.TDS;
import java.util.ArrayList;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Function extends BlocIdfParam
{
    
    protected String type_retour;
    public ArrayList<Instruction> instructions;
    
    public Function() {
        super(null);
    }

    public void setIdf(String idf) {
        this.idf = idf;
    }

    public void setType_retour(String type_retour) {
        this.type_retour = type_retour;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Function{" + "type_retour=" + type_retour + ", instructions=" + instructions + '}';
    }
    
    @Override
    public boolean verifier() throws SemantiqueException{
        super.verifier();
        TDS tds = TDS.getInstance();
        if(!type_retour.equals("entier") && tds.identifier(new Region(this.getNumBloc(),0,null),new Entree(type_retour, 0, "classe"))==null)
            GestionnaireSemantique.getInstance().add(new SemantiqueException(" : La fonction "+idf+" est de type "+type_retour+" non declaré"));
        
        for(Instruction i : instructions){
            i.numBloc=this.getNumBloc();
            i.verifier();
            if(i instanceof Retourne && !((Retourne) i).getType().equals(type_retour))
                GestionnaireSemantique.getInstance().add(new SemantiqueException("ligne "+i.line+" : le type de retour ne correspond pas avec le type de la fonction"));
        }
        return true;
    }
    
    @Override
    public String ecrireMips(){
        String str = GenerateurMIPS.getInstance().ecrireBloc("Fonction_"+idf+liste_param.toString());
        for(Instruction i : instructions){
            str += i.ecrireMips();
        }
        
        return str;
    }

}

