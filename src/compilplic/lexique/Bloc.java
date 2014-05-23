/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique;

import java.util.ArrayList;

/**
 *
 * @author Yan
 */
public abstract class Bloc {
    
    public Lexique lexique;

    private ArrayList<Bloc> l_bloc ;
    
    public Bloc() {
        l_bloc=new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    public void ajouterBloc(Bloc b) {
        l_bloc.add(b) ;
    }
    
    public abstract boolean verifier() throws Exception;
    
    public abstract String ecrireMips();

    public ArrayList<Bloc> getL_bloc() {
        return l_bloc;
    }

    public void setL_bloc(ArrayList<Bloc> l_bloc) {
        this.l_bloc = l_bloc;
    }
}
