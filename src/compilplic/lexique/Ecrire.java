package compilplic.lexique;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;
import compilplic.lexique.expression.Expression;
import compilplic.lexique.expression.Identificateur;
import compilplic.lexique.expression.Nombre;
import compilplic.tds.Entree;
import compilplic.tds.TDS;


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
        String str = GenerateurMIPS.getInstance().ecrireEntier();
        
        return str;
    }

    @Override
    public boolean verifier() throws Exception {
        System.out.println("Verif Ecrire\n");
        //Dans le cas où il y aurait d'autres methodes verifier pouvant retourner false
        /*if(value instanceof Identificateur){
            if(!((Identificateur) value).verifier())
                throw new SemantiqueException("La declaration de la variable "+((Identificateur) value).getNom()+" a la ligne "+line+" est manquante");
        }els
            ((Expression) value).verifier();*/
        
        //Pour le moment seule la methode verifier d'un identificateur peut retourner false
        if(!((Expression) value).verifier())
            throw new SemantiqueException("La declaration de la variable "+((Identificateur) value).getNom()+" a la ligne "+line+" est manquante");
        
        return true;
    }

}

