package compilplic.lexique.expression;

import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;

public class Somme extends Binaire {
    
    public boolean isBoolean;

    public Somme(Expression g, Expression d) {
            super(g,d) ;
            isBoolean = false;
    }

    @Override
    public Nombre calcul() {
            return new Nombre (gauche.calcul().toInt() + droite.calcul().toInt()) ;
    }
    
    @Override
    public String ecrireMips() {
        String str = gauche.ecrireMips();
        str+=droite.ecrireMips();
        if(!isBoolean())
            str+=GenerateurMIPS.getInstance().ecrireSomme();
        else
            str+=GenerateurMIPS.getInstance().ecrireOR(this.hashCode());
        
        return str;
    }

    @Override
    public boolean verifier() throws Exception {
        gauche.verifier();
        droite.verifier();
        if(gauche.isBoolean()){
            setBoolean();
            if(!droite.isBoolean()) throw new SemantiqueException("Expression droite arithmetique, booleenne attendue pour somme "+hashCode());
        }else
            if(droite.isBoolean()) throw new SemantiqueException("Expression droite booléenne, arithmetique attendu pour somme "+hashCode());
        
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
