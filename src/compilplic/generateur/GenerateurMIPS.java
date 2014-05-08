/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilplic.generateur;

/**
 * Cette classe est une collection de string representative du langage MIPS
 * @author ASUS
 */
public final class GenerateurMIPS {
    
    private static GenerateurMIPS instance ;
    private static int nbstr=0;
    
    public static GenerateurMIPS getInstance(){
        if(instance == null)
            instance = new GenerateurMIPS() ;
        return instance ;
    }
    
    /**
     * Permet de stocker directement un nombre dans la pile
     * @param i le nombre à stocker (entier)
     * @return le code Mips correspondant
     */
    public String ecrireNombre(int i){
        //Empile le nombre (Attention, pas de gestion du 32bit)
        return 
                "li $v0, "+i+"\n"
                +  "sw $v0, ($sp)\n"
                +  "add $sp, $sp, -4\n";
    }
    
    /**
     * Permet de charger le dernier element de la pile dans le registre v0
     * @return le code Mips associé
     */
    public String ecrireChargeV0(){
        return "add $sp, $sp, 4\n"
               + "lw $v0, ($sp)\n";
    }
    
    /**
     * Permet de charger l'operande droite et l'operande gauche si ils sont dans la pile (et se suivent)
     * @return le code Mips associe
     */
    public String ecrireChargeOperandes(){
                //Chargement de l'opérande droite
        return  ecrireChargeV0()
                //Chargement de l'opérande gauche
                + "add $sp, $sp, 4\n"
                + "lw $t8, ($sp)\n"; 
    }
    
    /**
     * Permet de stocker dans la pile la valeur du registre v0
     * @return le code Mips associe
     */
    public String ecrireStocker(){
        //Stockage dans la pile
        return  "sw $v0, ($sp)\n"
                + "add $sp, $sp, -4\n";
    }
    
    public String ecrireStockerT8(){
        return  "sw $t8, ($sp)\n"
                + "add $sp, $sp, -4\n";
    }
    
    /**
     * Permet de transferer la reference des variables de la pile dans $t7
     * @return le code Mips associe
     */
    public String ecrireInitialisation(){
        return 
                "#Initialisation\n"
                + "la $t7,($sp)\n"
                + "la $s7,($gp)\n"
                /*+ ".data\n"
                + "newline: .asciiz \"\\n\"\n"
                + ".text\n"*/;
    }
    
    /**
     * Permet de charger un entier dans le registre v0
     * @param i l'entier à charger
     * @return le code Mips associe
     */
    public String ecrireChargeEntier(int type){
        return "li $v0,"+type+"\n";
    }
    
    public String ecrireBranchContinue(int hash){
        return "b continue"+hash+"\n";
    }
    
    public String ecrireContinue(int hash){
        return "\ncontinue"+hash+":\n";
    }
    
    public String ecrireBloc(String s){
        return 
                "\n#Bloc"
                + "\n"+s+":\n";
    }
    
    /**
     * Permet d'ecrire une somme
     * @return le code Mips associe
     */
    public String ecrireSomme(){
        //Exemple sans les méthodes ci-dessus
        return 
                //Chargement de l'opérande droite
                "add $sp, $sp, 4\n"
                + "lw $v0, ($sp)\n"
                //Chargement de l'opérande gauche
                + "add $sp, $sp, 4\n"
                + "lw $t8, ($sp)\n"
                //Ajout des deux (dans v0)
                + "add $v0, $t8, $v0\n"
                + "sw $v0, ($sp)\n"
                + "add $sp, $sp, -4\n";
    }
    
    /**
     * Permet d'ecrire une soustraction
     * @return le code Mips associe
     */
    public String ecrireSoustraction(){
        return 
                ecrireChargeOperandes()
                //Soustraction des deux (dans v0)
                + "sub $v0, $t8, $v0\n"
                //Stockage dans la pile
                + ecrireStocker();
    }
    
    /**
     * Permet d'ecrire une multiplication
     * @return le code Mips associe
     */
    public String ecrireMultiplication(){
        return 
                ecrireChargeOperandes()
                //Multiplication des deux (dans v0)
                + "mul $v0, $t8, $v0\n"
                //Stockage dans la pile
                + ecrireStocker();
    }
    
    /**
     * Permet d'ecrire une division
     * @return le code Mips associe
     */
    public String ecrireDivision(){
        return 
                ecrireChargeOperandes()
                //Division des deux (dans v0)
                + "div $v0, $t8, $v0\n"
                //Stockage dans la pile
                + ecrireStocker();
    }
    
    /**
     * Permet d'ecrire le modulo
     * @return le code Mips associe
     */
    public String ecrireModulo(){
        return  
                ecrireDivision()
                + "mfhi $v0"
                + ecrireStocker();
    }
    
    /**
     * Permet d'ecrire une comparaison plus grand que de type "v0 > t8" (avec branchement)
     * @return le code Mips associe
     */
    public String ecrireGreaterThan(int hash){
        return  
                ecrireChargeOperandes()
                + "bgt $t8, $v0, greater"+hash+"\n"
                + ecrireChargeEntier(0)
                + ecrireBranchContinue(hash)
                + "\ngreater"+hash+":\n"
                + ecrireChargeEntier(1)
                + ecrireContinue(hash)
                + ecrireStocker();
    }
    
    /**
     * Permet d'ecrire une comparaison plus petit que de type "v0 < t8" (avec branchement)
     * @return le code Mips associe
     */
    public String ecrireLowerThan(int hash){
        return 
                ecrireChargeOperandes()
                + "blt $t8, $v0, lower"+hash+"\n"
                + ecrireChargeEntier(0)
                + ecrireBranchContinue(hash)
                + "\nlower"+hash+":\n"
                + ecrireChargeEntier(1)
                + ecrireContinue(hash)
                + ecrireStocker();
    }
    
    /**
     * Permet d'ecrire une comparaison egale de type "v0 == t8" (avec branchement)
     * @param hash le hashcode de l'objet afin d'avoir un identifiant unique pour les branches
     * @return le code Mips associe
     */
    public String ecrireEqual(int hash){
        return 
                ecrireChargeOperandes()
                + "beq $t8, $v0, equal"+hash+"\n"
                + ecrireChargeEntier(0)
                + ecrireBranchContinue(hash)
                + "\nequal"+hash+":\n"
                + ecrireChargeEntier(1)
                + ecrireContinue(hash)
                + ecrireStocker();
    }

    /**
     * Permet d'ecrire une comparaison differente de type "v0 != t8" (avec branchement)
     * @param hash le hashcode de l'objet afin d'avoir un identifiant unique pour les branches
     * @return le code Mips associe
     */
    public String ecrireNonEqual(int hash){
        return 
                ecrireChargeOperandes()
                + "bne $t8, $v0, non_equal"+hash+"\n"
                + ecrireChargeEntier(0)
                + ecrireBranchContinue(hash)
                + "\nnon_equal"+hash+":\n"
                + ecrireChargeEntier(1)
                + ecrireContinue(hash)
                + ecrireStocker();
    }
    
    /**
     * Permet d'ecrire un OU logique
     * @param hash le hashcode de l'objet afin d'avoir un identifiant unique pour les branches
     * @return 
     */
    public String ecrireOR(int hash){
        return 
                ecrireSomme()
                + ecrireChargeV0()
                + "bgt $v0, 0, OR"+hash+"\n"
                + ecrireChargeEntier(0)
                + ecrireBranchContinue(hash)
                + "\nOR"+hash+":\n"
                + ecrireChargeEntier(1)
                + ecrireContinue(hash)
                + ecrireStocker();
    }
    
    /**
     * Permet d'ecrire un OU logique
     * @param hash le hashcode de l'objet afin d'avoir un identifiant unique pour les branches
     * @return 
     */
    public String ecrireXOR(int hash){
        return 
                ecrireSoustraction()
                + ecrireChargeV0()
                + "beq $v0, 0, XOR"+hash+"\n"
                + ecrireChargeEntier(1)
                + ecrireBranchContinue(hash)
                + "\nXOR"+hash+":\n"
                + ecrireChargeEntier(0)
                + ecrireContinue(hash)
                + ecrireStocker();
    }
    
    /**
     * Permet d'ecrire un et logique
     * @param hash le hashcode de l'objet afin d'avoir un identifiant unique pour les branches
     * @return 
     */
    public String ecrireAND(int hash){
        return 
                ecrireMultiplication()
                + ecrireChargeV0()
                + "bgt $v0, 0, AND"+hash+"\n"
                + ecrireChargeEntier(0)
                + ecrireBranchContinue(hash)
                + "\nAND"+hash+":\n"
                + ecrireChargeEntier(1)
                + ecrireContinue(hash)
                + ecrireStocker();
    }
    
    /**
     * Permet d'afficher un entier
     * @return le code Mips associe
     */
    public String ecrireEntier(){
        return 
                "\n#ecrire entier\n"
                + "add $sp,$sp,4\n"
                + "lw $t8,($sp)\n"
                + ecrireChargeEntier(1)
                + "add $a0,$t8,$zero\n"
                + "syscall\n\n"
                /*+ ecrireNewLine()*/;
        
    }
    
    /**
     * Permet d'ecrire une nouvelle ligne
     * @return le code Mips associe
     */
    public String ecrireNewLine(){
        return 
                ecrireChargeEntier(4)
                + "la $a0,newline\n"
                + "syscall\n\n";
    }
    
    /**
     * Permet d'afficher une chaine de caractere
     * @param value la chaine de caracteres a afficher
     * @return le code Mips associe
     */
    public String ecrireString(String value){
        nbstr++;
        return 
                "#ecrire string\n"
                + ".data\n"
                + "str"+nbstr+": .asciiz \""+value+"\"\n"
                + ".text\n"
                + ecrireChargeEntier(4)
                + "la $a0,str"+nbstr+"\n"
                + "syscall\n\n";
    }

    /**
     * Permet de lire un entier
     * @return le code Mips associe
     */
    public String lireEntier(int deplacement, boolean global){
        return 
                "#lire entier\n"
                + ecrireChargeEntier(5)
                + "syscall\n"
                + "sw $v0,($sp)\n"
                + "add $sp,$sp,-4\n"
                + ecrireStockerIdentificateur(deplacement, global)+"\n";
    }
    
    /**
     * Permet de lire une chaine de caracteres (pas encore a implementer
     * @param value le string a lire
     * @return le code Mips associe
     */
    public String lireString(String value){
        return  
                "#lire string\n"
                + ecrireChargeEntier(8)
                + "la $a0,str"+value.hashCode()+"\n" //A verifier ça depend comment on le pense
                + "syscall\n\n";
    }
    
    /**
     * Permet d'ajouter une variable global
     * @return le code Mips associe
     */
    public String ecrireAjouterVarGlobale(){
        return  "sw $v0, ($gp)\n"
                + "add $gp, $gp, -4\n";
    }
    
    /**
     * Permet d'ajouter un champ
     * @return le code Mips associe
     */
    public String ecrireAjouterChamp(){
        return 
                ecrireChargeEntier(0)
                + ecrireAjouterVarGlobale();
    }
    
    /**
     * Permet d'ecrire une affectation
     * @param deplacement deplacement de la variable affectee
     * @param global true si la variable est global false sinon
     * @return le code Mips associe
     */
    public String ecrireAffectation(int deplacement, boolean global){
        return ecrireStockerIdentificateur(deplacement, global);
    }
    
    /**
     * Permet de recuperer la valeur d'une variable
     * @param deplacement deplacement de la variable
     * @param global true si la variable est globale false sinon (locale)
     * @return le code Mips associe
     */
    public String ecrireIdentificateur(int deplacement, boolean global) {
        if(global)
            return
                ecrireChargerVarGlobale(deplacement)
                + ecrireStocker();
        
        return
                ecrireChargerVarLocale(deplacement)
                + ecrireStocker();
    }
    
    /**
     * Permet de stocker la derniere valeur de la pile dans une variable locale ou globale
     * @param deplacement deplacement de la variable
     * @param global true si la variable est globale false sinon (locale)
     * @return le code Mips associe
     */
    public String ecrireStockerIdentificateur(int deplacement, boolean global){
        if(global)
            return
                ecrireChargeV0()
                + ecrireStockerGlobale(deplacement);
        
        return
                ecrireChargeV0()
                + ecrireStockerLocale(deplacement);
    }
    
    public String ecrireChargerVarGlobale(int deplacement){
        return "lw $v0,"+deplacement+"($s7)\n";
    }
    
    public String ecrireChargerVarLocale(int deplacement){
        return "lw $v0,"+deplacement+"($t7)\n";
    }
    
    public String ecrireStockerGlobale(int deplacement){
        return "sw $v0,"+deplacement+"($s7)\n";
    }
    
    public String ecrireStockerLocale(int deplacement){
        return "sw $v0,"+deplacement+"($t7)\n";
    }
    
    /**
     * Permet d'ajouter un bloc a la pile
     * @param adr l'adresse de retour
     * @param chainage_dyn le chainage dynamique
     * @param region la region (entier) du bloc (numero de bloc)
     * @return le code Mips associe
     */
    public String ecrireBloc(int adr, int chainage_dyn, int region){
        return 
                ecrireChargeEntier(adr)
                + ecrireStocker()
                + ecrireChargeEntier(chainage_dyn)
                + ecrireStocker()
                + ecrireChargeEntier(region)
                + ecrireStocker();
    }
}
