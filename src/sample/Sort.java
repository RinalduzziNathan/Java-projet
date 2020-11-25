package sample;

//class qui modelise un sort
public class Sort {


    private  int degats;
    private int coutMana;
    private  String nom;

    public Sort(int paramDegats,int paramCoutMana, String paramNom){
        degats=paramDegats;
        coutMana=paramCoutMana;
        nom=paramNom;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public int getCoutMana() {
        return coutMana;
    }

    public void setCoutMana(int coutMana) {
        this.coutMana = coutMana;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
