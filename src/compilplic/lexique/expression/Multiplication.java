package compilplic.lexique.expression;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;

public class Multiplication extends Binaire {

    public boolean isBoolean;

    public Multiplication(Expression g, Expression d, int l, int c) {
        super(g, d, l, c);
        isBoolean=false;
    }
	
    public Nombre calcul() {
            return new Nombre (gauche.calcul().toInt() * droite.calcul().toInt());
    }


    @Override
    public String ecrireMips() {
        String str = gauche.ecrireMips();
        str+=droite.ecrireMips();
        if(!isBoolean())
            str+=GenerateurMIPS.getInstance().ecrireMultiplication();
        else
            str+=GenerateurMIPS.getInstance().ecrireAND(this.hashCode());
        return str;
    }

    @Override
    public boolean verifier() throws Exception {
        gauche.verifier();
        droite.verifier();
        if(gauche.isBoolean()){
            setBoolean();
            if(!droite.isBoolean()) throw new SemantiqueException("Expression droite arithmetique, booleenne attendue pour le ET ");
        }else
            if(droite.isBoolean()) throw new SemantiqueException("Expression droite booléenne, arithmetique attendue pour la multiplication ");
        
        return true;
    }
    
    public void setBoolean(){
        isBoolean = true;
    }
    
    @Override
    public boolean isBoolean(){
        return isBoolean;
    }
}
