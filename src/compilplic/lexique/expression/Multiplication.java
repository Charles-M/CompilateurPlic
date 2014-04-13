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

            str+=GenerateurMIPS.getInstance().ecrireMultiplication()+"\n";

            str+=droite.ecrireMips();
        
            return str;
        }
}
