package compilplic.lexique.expression;

import compilplic.generateur.GenerateurMIPS;

public class Somme extends Binaire {

    public Somme(Expression g, Expression d) {
            super(g,d) ;
    }

    public Nombre calcul() {
            return new Nombre (gauche.calcul().toInt() + droite.calcul().toInt()) ;
    }

    @Override
    public String ecrireMips() {
        String str = gauche.ecrireMips();

        str+=GenerateurMIPS.getInstance().ecrireSomme();

        str+=droite.ecrireMips();

        return str;
    }

    @Override
    public boolean verifier() {
        if(!gauche.verifier() || gauche.isBoolean())
            return false;
        /*
        Si je dis pas de connerie, une expression Booleene est necessairemeent au dessus des expressions arithmetiques :
        (1+1) > 3  mais pas (1>3) + 1
        */
        
        if(!droite.verifier() || droite.isBoolean())
            return false;
        
        return true;
    }
}
