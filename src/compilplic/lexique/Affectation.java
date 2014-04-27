package compilplic.lexique;
import compilplic.lexique.expression.Expression;


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

        
}

