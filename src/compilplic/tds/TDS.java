/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.tds;

import compilplic.exception.DoubleDeclarationException;
import compilplic.exception.GestionnaireSemantique;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

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
    
    private HashMap<Region,HashMap<Entree,Symbole>> listeBloc ;
    private int num_bloc, num_imbrication ;
    private int deplacement;
    private int deplacement_actu;
    /**
     * Region region_actuelle (region_actuelle des regions qu'elle peut contenir)
     */
    private Region region_actuelle;
    
    /**
     * Declaration en cours de traitement (fonction, classe, constructeur)
     */
    private Entree entree_actuelle;

    private TDS() {
        num_bloc = num_imbrication = 0 ;
        listeBloc = new HashMap<>() ;
        deplacement=0;
        deplacement_actu=0;
    }
    
    public void ajouter(Entree e,String s) throws DoubleDeclarationException {
        if(listeBloc.get(region_actuelle).containsKey(e) && listeBloc.get(region_actuelle).get(e).getType().equals(s)){
            GestionnaireSemantique.getInstance().add(new DoubleDeclarationException(" a la ligne "+e.getLine()+" : la "+e.getEspace()+" "+e.getNom()+" est deja declaree"));
        }else{
            Symbole sym;
            if(!e.getEspace().equals("classe") && !e.getEspace().equals("fonction") && !e.getEspace().equals("constructeur")){
                /*if(s.equals("entier")){
                    sym = new Symbole(s,4);
                    deplacement+=4;
                }else{
                    sym = new Symbole(s,4);
                    deplacement+=4;
                }*/
                sym = new Symbole(s,deplacement_actu+=4);
                sym.setRegion(region_actuelle);
                deplacement+=4;
            }else{
                entree_actuelle = e;
                sym = new Symbole(s,0);
            }
            /*if(region_actuelle.getBloc()==1)
                sym.setGlobal(true);*/
            listeBloc.get(region_actuelle).put(e, sym);
            
        }
    }
    
    /**
     * Méthode permettant d'identifier une entree (Connaitre son type)
     * @param e l'entree que l'on veut identifier
     * @return le symbole de l'entrée si elle existe, null sinon
     */
    public Symbole identifier(Region region, Entree e){
        Region r = new Region(1,1,null);
        //Recherche de l'entrée
        if(listeBloc.get(r).containsKey(e))
            return listeBloc.get(r).get(e);
        
        r = region; /*new Region(num_bloc, num_imbrication, region_actuelle.getParent());*/
        System.err.println(r);
        if(r.getBloc()!=1){
            r=parcoursRegion(r, e);
            if(r!=null)
                return listeBloc.get(r).get(e);
        }
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
        try{
            System.out.println(e.getNom());
            System.out.println(region);
            //System.out.println(listeBloc);
        if(listeBloc.get(region).containsKey(e))
            return region;
        }catch(NullPointerException ne){
            ne.printStackTrace();
            System.exit(-1);
        }
        //Si on est là, l'entrée n'existe PAS dans cette region
        
        //Si la region est la dernière region (variables globales) l'entrée n'existe pas dans la TDS
        //Normalement une seule de ces conditions suffit
        if(region.getProfondeur()==2)
            return null;
        
        //On cherche par récurence dans les régions supérieures
        /*
        On a un prob, il faut mémoriser le bloc et la profondeur pour savoir où on en est dans la liste des blocs
        le numero de bloc ferait parcourir toute la liste avec une arraylist
        Autre hic, et là je sais pas trop comment le représenter, j'ai mis une region region_actuelle qui correspond à la region 
        au dessus dans la profondeur. A voir s'il y a pas mieux.
        On verra si ça va comme ça ou si y a plus simple
        */
        region=region.getParent();
        return parcoursRegion(region, e);
    }
    
    public void debutBloc(){
        
    }
    
    public void finBloc(){
        
    }
    
    public void entreeBloc(){
        num_bloc++ ;
        num_imbrication++ ;
        Region r = new Region(num_bloc,num_imbrication,region_actuelle);
        if(entree_actuelle!=null)
            r.setEntree(entree_actuelle);
        deplacement_actu=0;
        listeBloc.put(r,new HashMap<Entree, Symbole>());
        //La region region_actuelle est la nouvelle region dans laquelle on vient d'entrer
        this.region_actuelle=r;
        
    }
    
    public void sortieBloc() {
        num_imbrication-- ;
        //on sort du bloc donc la region region_actuelle redevient la region parent (au dessus dans la profondeur)
        
        //Array contenant les objets attributs ayant le même nom que la classe dans la quelle on est
        ArrayList<Entry<Entree,Symbole>> array = new ArrayList<>();
        //Parcours des variables locales
        int deplacement_actu=0;
        
        for (Entry<Entree,Symbole> entry : listeBloc.get(region_actuelle).entrySet()) {
            if(entry.getKey().getEspace().equals("variable"))
                deplacement_actu+=4;
            /*if(region_actuelle.getEntree().getEspace().equals("classe") && s.getType().equals(entree_actuelle.getNom()))
                array.add(entry);*/
        }
        //on remonte à la region parente (celle contenant la declaration de la region dont on est en train de sortir
        region_actuelle=region_actuelle.getParent();
        
        //Si ce n'est pas le bloc racine (ne contenant que des declarations de classes), on modifie le deplacement a effectué pour charger cette region
        if(!entree_actuelle.getNom().equals("racine"))
            listeBloc.get(region_actuelle).get(entree_actuelle).setDeplacement(deplacement_actu);
        
        //La declaration de la region actuelle est mise à jour
        entree_actuelle=region_actuelle.getEntree();
    }

    public HashMap<Region, HashMap<Entree, Symbole>> getListeBloc() {
        return listeBloc;
    }

    public void setListeBloc(HashMap<Region, HashMap<Entree, Symbole>> listeBloc) {
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
        //return "TDS{" + "listeBloc=" + listeBloc + ", num_bloc=" + num_bloc + ", num_imbrication=" + num_imbrication + ", actuelle=" + region_actuelle + '}';
        String str="";
        Region r;
        Entree e;
        Symbole s;
        for(Entry ent : listeBloc.entrySet()){
            r=(Region) ent.getKey();
            
            if(!r.getEntree().getNom().equals("racine"))
                str+=r.toString()+" "+listeBloc.get(r.getParent()).get(r.getEntree()).getDeplacement()+"\n";
            else
                str+=r.toString()+"\n"; 
            for(Entry entry : listeBloc.get(r).entrySet()){
                e = (Entree) entry.getKey();
                s = (Symbole) entry.getValue();
                str+="\t"+e.toString()+"->"+s.toString()+"\n";
            }
            str+="\n";
        }
        return str;
    }

    public int getDeplacement() {
        return deplacement;
    }
    
    public Region getRegionFromEntree(Entree e, String classe){
        for (Entry<Region, HashMap<Entree, Symbole>> entry : listeBloc.entrySet()) {
            Region region = entry.getKey();
            if(region.getEntree().equals(e)){
                return region;
            }   
        }
        return null;
    }
}
