package compilplic.lexique.expression;

import compilplic.generateur.GenerateurMIPS ;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Nombre extends Expression {

    private int nombre;

    public Nombre(int i) {
            nombre = i ;
    }

    public Nombre(Nombre n) {
            nombre = n.toInt() ;
    }

    public String toString() {
            return "N"+nombre+"H"+hashCode();
    }

    public Nombre calcul() {
            return this ;
    }

    public int toInt() {
            return nombre ;
    }

    public int nbrOperande() {
            return 1;
    }

    public Iterator<Nombre> iterator() {
            return new IteratorNombre();
    }

    class IteratorNombre implements Iterator<Nombre> {

            private boolean b = true ;

            public boolean hasNext() {
                    return b;
            }

            public Nombre next() {
                    if(!hasNext())
                            throw new NoSuchElementException() ;
                    b = false ;
                    return nbri(0);
            }

            public void remove() {

            }
    }

    public int nbrNombre() {
            return 1;
    }

    public Nombre nbri(int compteur) {
            return this;
    }
    
    @Override
    public boolean verifier() {
        return true;
    }
    
    @Override
    public String ecrireMips() {

        String str=GenerateurMIPS.getInstance().ecrireNombre(this.toInt());

        return str;
    }
    
    public boolean isZero(){
        return nombre==0;
    }

    @Override
    public String ecrireDot() {
        return "";
    }
}

