package expression;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class Binaire extends Expression {

	protected Expression gauche;
	protected Expression droite;

	public Binaire(Expression g, Expression d) {
		gauche = g ;
		droite = d ;
	}

	public Iterator<Nombre> iterator() {
		return new IteratorBinaire();
	}
	
	public int nbrOperande() {
		return 2 ;
	}
	
	public int nbrNombre(){
		return gauche.nbrNombre() + droite.nbrNombre() ;
	}
	
	public Nombre nbri(int i) {
		if(i < gauche.nbrNombre()) {
			return gauche.nbri(i) ;
		}
		else {
			return droite.nbri(i-gauche.nbrNombre()) ;
		}
	}
	
	class IteratorBinaire implements Iterator<Nombre>  {

		private int compteur = 0 ;
		
		public boolean hasNext() {
			return compteur < nbrNombre() ;
		}

		public Nombre next() {
			if(!hasNext())
				throw new NoSuchElementException() ;
			Nombre save = nbri(compteur) ;
			compteur++;
			return save;
		}

		public void remove() {
			
		}
		
	}
}
