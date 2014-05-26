/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.lexique.expression;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class AppelPointer extends Appel {
    
    private String objet ;    

    public AppelPointer(String objet, String nom_fonction, ArrayList<Expression> liste_param) {
        super(nom_fonction, liste_param);
        this.objet = objet;
    }
}
