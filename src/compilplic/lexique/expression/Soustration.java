package expression;

public class Soustration extends Binaire {

	public Soustration(Expression g, Expression d) {
		super(g, d) ;
	}
	
	public Nombre calcul() {
		return new Nombre (gauche.calcul().toInt() - droite.calcul().toInt());
	}

}
