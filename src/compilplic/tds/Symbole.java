/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilplic.tds;

/**
 *
 * @author Yan
 */
public class Symbole {
    
    private String type;
    private int deplacement;
    
    public Symbole(String t,int d){
        type=t;
        deplacement=d;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDeplacement() {
        return deplacement;
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }
    
}
