package compilplic.lexique.expression;

public class Somme extends Binaire {

	public Somme(Expression g, Expression d) {
		super(g,d) ;
	}
	
	public Nombre calcul() {
		return new Nombre (gauche.calcul().toInt() + droite.calcul().toInt()) ;
	}

}
