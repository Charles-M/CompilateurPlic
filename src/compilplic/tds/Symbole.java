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
    
    private String type, heritage;
    private int deplacement;
    private boolean global;
    
    public Symbole(String t,int d){
        type=t;
        deplacement=d;
        global=false;
    }

    public Symbole(String type, int deplacement, String heritage) {
        this.type = type;
        this.heritage = heritage;
        this.deplacement = deplacement;
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
    
    public String toString(){
        return "("+type+";"+deplacement+";"+heritage+")";
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }
    
}
