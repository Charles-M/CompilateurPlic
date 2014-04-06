package expression;

import java.io.Serializable;
import java.util.Iterator;

public abstract class Expression implements Iterable<Nombre> , Serializable {

	public abstract Nombre calcul() ;
	public abstract int nbrOperande() ;
	public abstract int nbrNombre() ;
	public abstract Iterator<Nombre> iterator() ;
	public abstract Nombre nbri(int compteur) ;

    public void ecrireMips() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
