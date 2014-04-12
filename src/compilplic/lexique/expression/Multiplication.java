package compilplic.lexique.expression;

import compilplic.generateur.GenerateurMIPS;

public class Multiplication extends Binaire {

	public Multiplication(Expression g, Expression d) {
		super(g, d) ;
	}
	
	public Nombre calcul() {
		return new Nombre (gauche.calcul().toInt() * droite.calcul().toInt());
	}

        
        @Override
        public String ecrireMips() {
            String str = gauche.ecrireMips();

            str+=GenerateurMIPS.getInstance().ecrireMultiplication();

            str+=droite.ecrireMips();
        
            return str;
        }

    @Override
    public boolean verifier() {
        if(!gauche.verifier() || gauche.isBoolean())
            return false;
        /*
        Si l'une des expressions est semantiquement fausse -> false
        Si je dis pas de connerie, une expression Booleene est necessairemeent au dessus des expressions arithmetiques :
        (1*1) > 3  mais pas (1>3) * 1
        donc si booleen en dessous de arithmetique (ici somme) -> false
        */
        
        if(!droite.verifier() || droite.isBoolean())
            return false;
        
        return true;
    }
}
