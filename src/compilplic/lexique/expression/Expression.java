package compilplic.lexique.expression;

import java.io.Serializable;
import java.util.Iterator;

public abstract class Expression implements Iterable<Nombre> , Serializable {

	public abstract Nombre calcul() ;
	public abstract int nbrOperande() ;
	public abstract int nbrNombre() ;
	public abstract Iterator<Nombre> iterator() ;
	public abstract Nombre nbri(int compteur) ;
        
        public abstract boolean verifier();
        
        public abstract String ecrireMips() ;
        
        public boolean isBoolean(){
            return false;
        }
        
        public boolean isZero(){
            return false;
        }
    
}
