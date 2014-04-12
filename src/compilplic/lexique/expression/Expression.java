package compilplic.lexique.expression;

import java.io.Serializable;
import java.util.Iterator;

public abstract class Expression implements Iterable<Nombre> , Serializable {

	public abstract Nombre calcul() ;
	public abstract int nbrOperande() ;
	public abstract int nbrNombre() ;
	public abstract Iterator<Nombre> iterator() ;
	public abstract Nombre nbri(int compteur) ;
        
        /**
         * Execute l'analyse semantique
         * @return true si la semantique est bonne (j'aimerai bien savoir qui c'est :p), false sinon
         */
        public abstract boolean verifier();
        
        /**
         * Permet de generer le code Mips
         * @return 
         */
        public abstract String ecrireMips() ;
        
        /**
        * Indique si l'expression est booleenne ou non
        * @return true si booleenne, false sinon
        */
        public boolean isBoolean(){
            return false;
        }
        
        public boolean isZero(){
            return false;
        }
    
}
