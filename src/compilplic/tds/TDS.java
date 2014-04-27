/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.tds;

import java.util.HashMap;

/**
 * La fameuse table des symboles, a faire avec le cours
 * @author ASUS
 */
public class TDS {
    
    private static TDS instance ;
    public static TDS getInstance() {
        if(instance == null)
            instance = new TDS() ;
        return instance ;
    }
    
    private HashMap<Region,HashMap<Entree,String>> listeBloc ;
    private int num_bloc, num_imbrication ;
    
    /**
     * Region actuelle (actuelle des regions qu'elle peut contenir)
     */
    private Region actuelle;

    private TDS() {
        num_bloc = num_imbrication = 0 ;
        listeBloc = new HashMap<>() ;
    }
    
    public void ajouter(Entree e,String s) throws DoubleDeclarationException {
        if(listeBloc.get(actuelle).containsKey(e))
            throw new DoubleDeclarationException(e,s);
        else
            listeBloc.get(actuelle).put(e, s);
    }
    
    /**
     * Méthode permettant d'identifier une entree (Connaitre son type)
     * @param e l'entree que l'on veut identifier
     * @return le symbole de l'entrée si elle existe, null sinon
     */
    public String identifier(Entree e){
        
        //Recherche de l'entrée
        Region r = new Region(num_bloc, num_imbrication, actuelle.getParent());
        r=parcoursRegion(r, e);
        if(r!=null)
            return listeBloc.get(r).get(e);
        return null;
    }
    
    /**
     * Permet de remonter les regions afin d'identifier une entree
     * @param region la region dans laquelle on cherche actuellement
     * @param e l'entree recherchee
     * @return la region de la variable si elle existe, null sinon
     */
    public Region parcoursRegion(Region region, Entree e){
        //On vérifie si l'entrée existe dans cette région
        if(listeBloc.get(region).containsKey(e))
            return region;
        
        //Si on est là, l'entrée n'existe PAS dans cette region
        
        //Si la region est la dernière region (variables globales) l'entrée n'existe pas dans la TDS
        if(region.getProfondeur()==0 || region.getBloc()==0)
            return null;
        
        //On cherche par récurence dans les régions supérieures
        /*
        On a un prob, il faut mémoriser le bloc et la profondeur pour savoir où on en est dans la liste des blocs
        le numero de bloc ferait parcourir toute la liste avec une arraylist
        Autre hic, et là je sais pas trop comment le représenter, j'ai mis une region actuelle qui correspond à la region 
        au dessus dans la profondeur. A voir s'il y a pas mieux.
        On verra si ça va comme ça ou si y a plus simple
        */
        region=region.getParent();
        return parcoursRegion(region, e);
    }
    
    public void entreeBloc(){
        num_bloc++ ;
        num_imbrication++ ;
        Region r = new Region(num_bloc,num_imbrication,actuelle);
        listeBloc.put(r,new HashMap<Entree, String>());
        //La region actuelle est la nouvelle region dans laquelle on vient d'entrer
        this.actuelle=r;
        
    }
    
    public void sortieBloc() {
        num_imbrication-- ;
        //on sort du bloc donc la region actuelle redevient la region parent (au dessus dans la profondeur)
        actuelle=actuelle.getParent();
    }

    public HashMap<Region, HashMap<Entree, String>> getListeBloc() {
        return listeBloc;
    }

    public void setListeBloc(HashMap<Region, HashMap<Entree, String>> listeBloc) {
        this.listeBloc = listeBloc;
    }

    public int getNum_bloc() {
        return num_bloc;
    }

    public void setNum_bloc(int num_bloc) {
        this.num_bloc = num_bloc;
    }

    public int getNum_imbrication() {
        return num_imbrication;
    }

    public void setNum_imbrication(int num_imbrication) {
        this.num_imbrication = num_imbrication;
    }

    @Override
    public String toString() {
        return "TDS{" + "listeBloc=" + listeBloc + ", num_bloc=" + num_bloc + ", num_imbrication=" + num_imbrication + ", actuelle=" + actuelle + '}';
    }
    
}
