/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class BlocIdfParam extends BlocIdf {

    protected ArrayList<String> liste_param ;
    
    public BlocIdfParam(String idf) {
        super(idf);
        liste_param = new ArrayList<String>() ;
    }
    
    public void ajouterParam(String t) {
        liste_param.add(t) ;
    }
}