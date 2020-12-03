package sample;

import javafx.scene.image.Image;

public abstract class Personnage {


    //attributs
    private int PvMax;
    private int ManaMax;

    //variable utilisée pour la sauvegarde des perso en fichier
    protected String TypePerso;
    protected Image imgClass;

    private int pv;
    private int mana;
    private int lvl;
    private String nom;

    //mes constructeurs
    public Personnage(){
        pv = 100;
        mana = 100;
        lvl = 0;
        nom = "Anon";
        PvMax=pv;
        ManaMax = mana;
    }
    public  Personnage(int parampv,int parammana,int paramlvl, String paramNom){
        pv = parampv;
        mana = parammana;
        lvl = paramlvl;
        nom = paramNom;
        PvMax=pv;
        ManaMax = mana;
    }

    //gestion vie/mana

    //return true si action fonctionne, sinon false
    boolean UtiliserMana(int cout){
        //compter le mana seulement si on a assez de mana
        if(mana-cout<0){
            mana =0;
            return false;
        }else {
            mana = mana - cout;
            return  true;
        }
    }

    void GagnerMana(int montant){
         mana= montant+mana;
    }

    boolean PrendreDesDegats(int degats){
        //Si le joueur est mort
        if(pv-degats<=0){
            pv=0;
            System.out.println("JOUEUR " + nom + " EST MORT ");
            return false;
        }else {
            pv = pv - degats;
            return  true;
        }
    }

    void Soigner(int montant){
        pv = montant+pv;
    }

    //gagner un niveau, fct appelé quand notre perso gagne un niveau, il augmente ses stats max, mais cette fonction sera redéfinie car le lvl upde chaque class est différent
    void GagnerNiveau(){
        System.out.println("Classe non spécialisée");
    }




    // les get/set

    public String getTypePerso(){return TypePerso;}
    public Image getImg(){return imgClass;}

    public int getPvMax() {
        return PvMax;
    }

    public void setPvMax(int pvMax) {
        PvMax = pvMax;
    }

    public int getManaMax() {
        return ManaMax;
    }

    public void setManaMax(int manaMax) {
        ManaMax = manaMax;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
