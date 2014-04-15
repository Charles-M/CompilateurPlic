package compilplic.lexique.expression;

import compilplic.generateur.GenerateurMIPS;

public class Soustraction extends Binaire {
    private boolean isBoolean;

    public Soustraction(Expression g, Expression d, int l, int c) {
        super(g, d, l, c);
        isBoolean = false;
    }

    public Nombre calcul() {
            return new Nombre (gauche.calcul().toInt() - droite.calcul().toInt());
    }

    @Override
    public String ecrireMips() {
        String str = gauche.ecrireMips();
        str+=droite.ecrireMips();
        if(!isBoolean())
            str+=GenerateurMIPS.getInstance().ecrireSoustraction();
        else
            str+=GenerateurMIPS.getInstance().ecrireXOR(this.hashCode());
        
        return str;
    }

    @Override
    public boolean verifier() throws Exception {
        gauche.verifier();
        droite.verifier();
        if(gauche.isBoolean()){
            setBoolean();
            if(!droite.isBoolean()) throw new Exception("Expression droite arithmetique, booleenne attendue pour le XOR ");
        }else
            if(droite.isBoolean()) throw new Exception("Expression droite booléenne, arithmetique attendu pour Soustraction ");
        
        return true;
    }

    private void setBoolean() {
        isBoolean = true ;
    }
    
    
    @Override
    public boolean isBoolean(){
        return isBoolean;
    }
        
}
