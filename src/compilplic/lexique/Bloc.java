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
    
    public static int num=1;
    public Lexique lexique;
    private int numBloc;
    
    private ArrayList<Bloc> l_bloc ;
    
    public Bloc() {
        l_bloc=new ArrayList<>();
        num++;
        numBloc=num;
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

    public int getNumBloc() {
        return numBloc;
    }

    public void setNumBloc(int numBloc) {
        this.numBloc = numBloc;
    }
    
}
