package compilplic.lexique.expression;

import compilplic.exception.GestionnaireSemantique;
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
    public boolean verifier() throws SemantiqueException {
        super.verifier();
        if(gauche.isBoolean()){
            setBoolean();
            if(!droite.isBoolean()) GestionnaireSemantique.getInstance().add(new SemantiqueException("Expression droite arithmetique, booleenne attendue pour le ET ligne:"+line+" colonne:"+col));
        }else
            if(droite.isBoolean()) GestionnaireSemantique.getInstance().add(new SemantiqueException("Expression droite booléenne, arithmetique attendue pour la multiplication ligne:"+line+" colonne:"+col));
        
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
