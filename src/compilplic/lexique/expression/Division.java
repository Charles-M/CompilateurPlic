package compilplic.lexique.expression;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;

public class Division extends Binaire {

    public Division(Expression g, Expression d, int l, int c) {
        super(g, d, l, c);
    }

    public Nombre calcul() {
            return new Nombre (gauche.calcul().toInt() / droite.calcul().toInt());
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        super.verifier();
        if(gauche.isBoolean())
            GestionnaireSemantique.getInstance().add(new SemantiqueException("Expression gauche de la division est booléenne, arithmétique attendue ligne:"+line+" colonne:"+col));
        
        if(droite.isBoolean())
            GestionnaireSemantique.getInstance().add(new SemantiqueException("Expression droite de la division est booléenne, arithmétique attendue ligne:"+line+" colonne:"+col));
        
        //Pas de division par 0
        if(droite.isZero())
            GestionnaireSemantique.getInstance().add(new SemantiqueException("Division par 0 ligne:"+line+" colonne:"+col));
        
        return true;
    }
    
    @Override
    public String ecrireMips() {
        String str = gauche.ecrireMips();
        str+=droite.ecrireMips();
        str+=GenerateurMIPS.getInstance().ecrireDivision();
        
        return str;
    }
    
}
