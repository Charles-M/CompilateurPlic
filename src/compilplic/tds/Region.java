package compilplic.tds;

/**
 * Une region dans le code avec son numéro de bloc et sa profondeur
 * Pour comprendre pourquoi j'ai créé cette classe voir la fonction parcoursRegion de la TDS
 * @author Yan
 */
public class Region {
    
    /**
     * Le numero de bloc de la region
     */
    private int bloc;
    
    /**
     * La profondeur dans le code de la region
     */
    private int profondeur;
    
    /**
     * Region d'au dessus
     */
    private Region parent;
    
    /**
     * Indique l'entree correspondant a la declaration de cette region
     */
    private Entree entree;
    
    public Region(int bloc, int profondeur, Region parent){
        this.bloc=bloc;
        this.profondeur=profondeur;
        this.parent=parent;
        entree=new Entree("racine", 0);
    }

    public int getBloc() {
        return bloc;
    }

    public void setBloc(int bloc) {
        this.bloc = bloc;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    public Region getParent() {
        return parent;
    }

    public void setParent(Region parent) {
        this.parent = parent;
    }

    public Entree getEntree() {
        return entree;
    }

    public void setEntree(Entree entree) {
        this.entree = entree;
    }
    
    /**
     * Methode permettant de dire si deux region sont identiques ou non
     * @param o la region comparé à cette region (this)
     * @return true si les regions sont identique, false sinon
     */
    @Override
    public boolean equals(Object o){
        if(o==this)
            return true;
        
        Region r = (Region) o;
        
        /* Pas besoin de verifier le parent, en théorie tout ça suffit......... ET BAH NAN !
         * Quoi ? imcomprehensible ce bazar
         */
        //if(profondeur==1) return true ;
        System.out.println("compare : "+r.bloc+" "+bloc);
        return bloc==r.bloc;//(this.bloc==r.bloc && this.profondeur==r.profondeur);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        //if(profondeur!=1)
            hash = 97 * hash + this.bloc;
        //hash = 97 * hash + this.profondeur;
        return hash;
    }
    
    @Override
    public String toString(){
        return "Region : "+entree.getEspace()+" "+entree.getNom()+" "+bloc+" "+profondeur;
    }
    
}
