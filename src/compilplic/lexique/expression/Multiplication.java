package compilplic.lexique.expression;

import compilplic.generateur.GenerateurMIPS;

public class Multiplication extends Binaire {

        public boolean isBoolean;
    
	public Multiplication(Expression g, Expression d) {
		super(g, d) ;
                isBoolean=false;
	}
	
	public Nombre calcul() {
		return new Nombre (gauche.calcul().toInt() * droite.calcul().toInt());
	}

        
        @Override
        public String ecrireMips() {
            String str = gauche.ecrireMips();
            str+=droite.ecrireMips();
            if(!isBoolean())
                str+=GenerateurMIPS.getInstance().ecrireMultiplication();
            else
                str+=GenerateurMIPS.getInstance().ecrireAND(this.hashCode());
            return str;
        }

    @Override
    public boolean verifier() throws Exception {
        gauche.verifier();
        droite.verifier();
        if(gauche.isBoolean()){
            setBoolean();
            if(!droite.isBoolean()) throw new Exception("Expression droite arithmetique, booleenne attendue pour multiplication "+hashCode());
        }else
            if(droite.isBoolean()) throw new Exception("Expression droite booléenne, arithmetique attendue pour multiplication "+hashCode());
        
        return true;
    }
    
    public void setBoolean(){
        isBoolean = true;
    }
    
    @Override
    public boolean isBoolean(){
        return isBoolean;
    }
}
