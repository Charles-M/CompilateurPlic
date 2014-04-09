package compilplic.lexique.expression;

public class Multiplication extends Binaire {

	public Multiplication(Expression g, Expression d) {
		super(g, d) ;
	}
	
	public Nombre calcul() {
		return new Nombre (gauche.calcul().toInt() * droite.calcul().toInt());
	}

}
