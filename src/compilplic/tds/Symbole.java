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
    private boolean global;
    private Region region;
    
    public Symbole(String t,int d){
        type=t;
        deplacement=d;
        global=false;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    
    public String toString(){
        return "("+type+";"+deplacement+")";
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }
    
}
