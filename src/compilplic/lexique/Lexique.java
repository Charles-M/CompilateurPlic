package compilplic.lexique;

import java.util.ArrayList;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Lexique {
	
	protected ArrayList<Bloc> liste_bloc ;
	
	public Lexique(){
		liste_bloc = new ArrayList<>() ;
	}
        
        public void ajouterBloc(Bloc_IDF b) {
            liste_bloc.add(b) ;
        }
    
        
        public void ajouterDecl(int i, Declaration d) {
            liste_bloc.get(i).ajouterDecl(d) ;
        }

        public boolean verifier() throws Exception {
            System.out.println("Verif Lexique\n");
            for(Bloc b : liste_bloc)
                b.verifier();
            
            return true;
        }

	public String ecrireMips() {
            String str = "";
            for(Bloc b : liste_bloc)
                str+=b.ecrireMips();
            
            return str;
	}

    @Override
    public String toString() {
        return "Lexique{" + "liste_bloc=" + liste_bloc + '}';
    }

        
        
	
}

