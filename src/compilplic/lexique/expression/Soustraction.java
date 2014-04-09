package compilplic.lexique.expression;

public class Soustraction extends Binaire {

	public Soustraction(Expression g, Expression d) {
		super(g, d) ;
	}
	
	public Nombre calcul() {
		return new Nombre (gauche.calcul().toInt() - droite.calcul().toInt());
	}

}
