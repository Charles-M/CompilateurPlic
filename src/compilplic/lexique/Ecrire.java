package compilplic.lexique;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;
import compilplic.lexique.expression.Expression;
import compilplic.lexique.expression.Identificateur;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Ecrire extends Instruction
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Object value;

    public Ecrire(Object value, int line) {
        super(line);
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString()+" expr="+value; //To change body of generated methods, choose Tools | Templates.
    }
        
        

    @Override
    public String ecrireMips() {
        String str;
        if(value instanceof String){
            String val = (String) value;
            val=val.substring(1, val.length()-1);
            if(val.contains("\"")){
                val = val.replaceAll("\"", "\\\\\"");
            }
            str = GenerateurMIPS.getInstance().ecrireString(val);
        }else{
            str = ((Expression) value).ecrireMips();
            str += GenerateurMIPS.getInstance().ecrireEntier();
        }
        
        return str;
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        //Dans le cas où il y aurait d'autres methodes verifier pouvant retourner false
        /*if(value instanceof Identificateur){
            if(!((Identificateur) value).verifier())
                throw new SemantiqueException("La declaration de la variable "+((Identificateur) value).getNom()+" a la ligne "+line+" est manquante");
        }els
            ((Expression) value).verifier();*/
        
        //Pour le moment seule la methode verifier d'un identificateur peut retourner false
        
        if(value instanceof Expression && !((Expression) value).verifier())
            throw new SemantiqueException("La declaration de la variable "+((Identificateur) value).getNom()+" a la ligne "+line+" est manquante");
        
        return true;
    }

}

