package expression;

public class Division extends Binaire {

	public Division(Expression g, Expression d) {
		super(g, d) ;
	}
	
	public Nombre calcul() {
		return new Nombre (gauche.calcul().toInt() / droite.calcul().toInt());
	}

}
