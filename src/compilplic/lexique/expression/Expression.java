package compilplic.lexique.expression;

import compilplic.exception.SemantiqueException;
import java.io.Serializable;
import java.util.Iterator;

public abstract class Expression implements Iterable<Nombre> , Serializable {

	public abstract Nombre calcul() ;
	public abstract int nbrOperande() ;
	public abstract int nbrNombre() ;
	public abstract Iterator<Nombre> iterator() ;
	public abstract Nombre nbri(int compteur) ;
        private String type;
        protected int numBloc;
        
        /**
         * Execute l'analyse semantique
         * @return true si la semantique est bonne (j'aimerai bien savoir qui c'est :p), false sinon
         */
        public abstract boolean verifier() throws SemantiqueException;
        
        /**
         * Permet de generer le code Mips
         * @return 
         */
        public abstract String ecrireMips() ;
        
        /**
         * Permet de generer le code Dot
         * @return 
         */
        public abstract String ecrireDot() ;
        
        /**
        * Indique si l'expression est booleenne ou non
        * @return true si booleenne, false sinon
        */
        public boolean isBoolean(){
            return false;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
        
        
        public boolean isZero(){
            return false;
        }

    public int getNumBloc() {
        return numBloc;
    }

    public void setNumBloc(int numBloc) {
        this.numBloc = numBloc;
    }
        
}
