 package compilplic.lexique;

import compilplic.generateur.GenerateurMIPS;
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
            liste_bloc.add(new Classe("root"));
        }
        
        public void ajouterBloc(int bloc, BlocIdf b) {
            liste_bloc.add(b) ;
            liste_bloc.get(bloc).ajouterBloc(b);
        }
        
        public void ajouterParam(int bloc, String t) {
            ((BlocIdfParam)(liste_bloc.get(bloc))).ajouterParam(t);
        }

        public boolean verifier() throws Exception {
            for(Bloc b : liste_bloc)
                b.verifier();
            
            return true;
        }

	public String ecrireMips() {
            String str = "";
            str+=GenerateurMIPS.getInstance().ecrireInitialisation();
            for(Bloc b : liste_bloc)
                str+=b.ecrireMips();
            
            return str;
	}

    public ArrayList<Bloc> getListe_bloc() {
        return liste_bloc;
    }

        
    @Override
    public String toString() {
        return "Lexique{" + "liste_bloc=" + liste_bloc + '}';
    }

        
        
	
}

