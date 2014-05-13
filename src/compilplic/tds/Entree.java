/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.tds;

import java.util.Objects;

/**
 * Represente une entree de la TDS
 * @author ASUS
 */
public class Entree {
    
    private String nom, espace ;
    private int line ;

    public Entree(String nom, int l) {
        this.nom = nom;
        this.line = l ;
        this.espace="entier";
    }

    public Entree(String nom, int l, String espace) {
        this.nom = nom;
        this.line = l ;
        this.espace = espace ;
    }

    public String getNom() {
        return nom;
    }

    public int getLine() {
        return line;
    }

    public void setEspace(String espace) {
        this.espace = espace;
    }

    public String getEspace() {
        return espace;
    }
    
    /**
     * Methode permettant de comparer deux entree
     * @param o l'entree avec laquelle on veut comparer this
     * @return true si les entree sont identique false sinon
     */
    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        
        Entree e = (Entree) o;
        return this.nom.equals(e.getNom()) && espace.equals(e.getEspace());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nom);
        return hash;
    }
}
