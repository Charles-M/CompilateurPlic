package compilplic.lexique.expression;

import compilplic.exception.GestionnaireSemantique;
import compilplic.exception.SemantiqueException;
import compilplic.generateur.GenerateurMIPS;

public class Soustraction extends Binaire {
    private boolean isBoolean;

    public Soustraction(Expression g, Expression d, int l, int c) {
        super(g, d, l, c);
        isBoolean = false;
    }

    public Nombre calcul() {
            return new Nombre (gauche.calcul().toInt() - droite.calcul().toInt());
    }

    @Override
    public String ecrireMips() {
        String str = gauche.ecrireMips();
        str+=droite.ecrireMips();
        if(!isBoolean())
            str+=GenerateurMIPS.getInstance().ecrireSoustraction();
        else
            str+=GenerateurMIPS.getInstance().ecrireXOR(this.hashCode());
        
        return str;
    }

    @Override
    public boolean verifier() throws SemantiqueException {
        super.verifier();
        if(gauche.isBoolean()){
            setBoolean();
            if(!droite.isBoolean()) GestionnaireSemantique.getInstance().add(new SemantiqueException("Expression droite arithmetique, booleenne attendue pour le XOR ligne:"+line+" colonne:"+col));
        }else{
            
                
            if(droite.isBoolean()) {
                if(gauche instanceof Nombre && ((Nombre) gauche).getNombre()==0){
                    setBoolean();
                    ((Nombre) gauche).setNombre(1);
                }else
                    GestionnaireSemantique.getInstance().add(new SemantiqueException("Expression droite booléenne, arithmetique attendu pour Soustraction ligne:"+line+" colonne:"+col));
            }
        }
        
        return true;
    }

    private void setBoolean() {
        isBoolean = true ;
    }
    
    
    @Override
    public boolean isBoolean(){
        return isBoolean;
    }
        
}
