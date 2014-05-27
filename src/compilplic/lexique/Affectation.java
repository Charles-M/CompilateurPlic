package compilplic.lexique;
import compilplic.exception.GestionnaireSemantique;
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
    public boolean verifier() throws SemantiqueException {
        TDS tds = TDS.getInstance();
        Symbole s = tds.identifier(new Entree(var, 0));
        if(s==null)
            GestionnaireSemantique.getInstance().add(new SemantiqueException("La declaration de la variable "+var+" a la ligne "+line+" est manquante"));
        
        if(!expression.verifier())
            GestionnaireSemantique.getInstance().add(new SemantiqueException("La declaration de la variable "+((Identificateur) expression).getNom()+" a la ligne "+line+" est manquante"));
        
        if(expression.isBoolean())
            GestionnaireSemantique.getInstance().add(new SemantiqueException("Expression booleenne trouvee a la ligne "+line+", expression entiere attendue"));
        
        return true;
    }

    @Override
    public String ecrireMips() {
        TDS tds = TDS.getInstance();
        Symbole s = tds.identifier(new Entree(var, 0,"variable"));
        return expression.ecrireMips()+
                GenerateurMIPS.getInstance().ecrireAffectation(s.getDeplacement(),s.isGlobal());
    }

}

