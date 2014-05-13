package compilplic.lexique.expression;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class Binaire extends Expression {

    protected Expression gauche;
    protected Expression droite;
    protected int line, col ;

    public Binaire(Expression g, Expression d, int l, int c) {
            gauche = g ;
            droite = d ;
            line = l ;
            col = c ;
    }

    public void setGauche(Expression gauche) {
        this.gauche = gauche;
    }

    public void setDroite(Expression droite) {
        this.droite = droite;
    }

    public Expression getDroite() {
        return droite;
    }

    public Expression getGauche() {
        return gauche;
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

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+hashCode() ;
    }

    @Override
    public String ecrireDot() {
        String s = gauche.ecrireDot() ;
        s += droite.ecrireDot() ;
        s += this + "->" + gauche + "\n" + this + "->" + droite +"\n"; 
        return s ;
    }
    
    @Override
    public boolean verifier() throws SemantiqueException {
        if(gauche instanceof Identificateur && !gauche.verifier()){
                GestionnaireSemantique.getInstance().add(new SemantiqueException("La declaration de la variable "+((Identificateur) gauche).getNom()+" a la ligne "+line+" est manquante"));
        }else
            gauche.verifier();
        
        if(droite instanceof Identificateur && !droite.verifier()){
               GestionnaireSemantique.getInstance().add(new SemantiqueException("La declaration de la variable "+((Identificateur) droite).getNom()+" a la ligne "+line+" est manquante"));
        }else
            droite.verifier();
        
        return true;
    }
    
}
