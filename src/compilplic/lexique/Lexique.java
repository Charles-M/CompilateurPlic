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
        
        public void ajouterBloc(Bloc b) {
            liste_bloc.add(b) ;
        }
    
        
        public void ajouterDecl(int i, Declaration d) {
            liste_bloc.get(i).ajouterDecl(d) ;
        }
    

	public String ecrireMips() {
		// TODO : to implement
		return "";	
	}

    @Override
    public String toString() {
        return "Lexique{" + "liste_bloc=" + liste_bloc + '}';
    }

        
        
	
}

