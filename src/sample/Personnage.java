package sample;

public abstract class Personnage {


    //attributs
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
    }
    public  Personnage(int parampv,int parammana,int paramlvl, String paramNom){
        pv = paramlvl;
        mana = parammana;
        lvl = paramlvl;
        nom = paramNom;
    }

    //gestion vie/mana

    //return true si action fonctionne, sinon false
    boolean UtiliserMana(int cout){
        //compter le mana seulement si on a assez de mana
        if(mana-cout<0){
            return false;
        }else {
            mana = mana - cout;
            return  true;
        }
    }

    void GagnerMana(int montant){
         mana= montant+mana;
    }

    boolean PerdreVie(int degats){
        //Si le joueur est mort
        if(pv-degats<=0){
            System.out.println("JOUEUR " + nom + " EST MORT");
            return false;
        }else {
            pv = pv - degats;
            return  true;
        }
    }

    void Soigner(int montant){
        pv = montant+pv;
    }



    // les get/set
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
