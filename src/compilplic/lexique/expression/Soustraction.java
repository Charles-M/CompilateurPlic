package compilplic.lexique.expression;

import compilplic.generateur.GenerateurMIPS;

public class Soustraction extends Binaire {

	public Soustraction(Expression g, Expression d) {
		super(g, d) ;
	}
	
	public Nombre calcul() {
		return new Nombre (gauche.calcul().toInt() - droite.calcul().toInt());
	}

        @Override
        public String ecrireMips() {
            String str = gauche.ecrireMips();

            str+=GenerateurMIPS.getInstance().ecrireSoustraction()+"\n";

            str+=droite.ecrireMips();

            return str;
        }
        
}
