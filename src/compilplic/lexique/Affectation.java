package compilplic.lexique;
import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;
import compilplic.lexique.expression.Expression;
import compilplic.lexique.expression.Identificateur;
import compilplic.tds.Entree;
import compilplic.tds.Symbole;
import compilplic.tds.TDS;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Affectation extends Instruction
{
    private String var ;
    private Expression expression;
    
    public Affectation(String var, Expression expression, int line) {
        super(line);
        this.var = var;
        this.expression = expression;
    }


    @Override
    public String toString() {
        return super.toString()+" expr="+expression ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifier() throws Exception {
        System.out.println("Verif Affectation\n");
         TDS tds = TDS.getInstance();
        Symbole s = tds.identifier(new Entree(var));
        if(s==null)
            throw new SemantiqueException("La declaration de la variable "+var+" a la ligne "+line+" est manquante");
        
        if(!expression.verifier())
            throw new SemantiqueException("La declaration de la variable "+((Identificateur) expression).getNom()+" a la ligne "+line+" est manquante");
        return true;
    }

    @Override
    public String ecrireMips() {
        TDS tds = TDS.getInstance();
        Symbole s = tds.identifier(new Entree(var));
        return expression.ecrireMips()+
                GenerateurMIPS.getInstance().ecrireAffectation(s.getDeplacement());
    }

}

