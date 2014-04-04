/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.tds;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * La fameuse table des symboles, a faire avec le cours
 * @author ASUS
 */
public class TDS {
    
    private ArrayList<HashMap<Entree,String>> listeBloc ;
    private int num_bloc, num_imbrication ;

    public TDS() {
        num_bloc = num_imbrication = 0 ;
        listeBloc = new ArrayList<HashMap<Entree, String>>() ;
    }
    
    public void entreeBloc(){
        num_bloc++ ;
        num_imbrication++ ;
    }
    
    public void sortieBloc() {
        num_imbrication-- ;
    }
    
}
