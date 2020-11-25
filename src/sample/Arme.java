package sample;

//représente la classe de base des armes (arc / epée / bouclier)
public abstract class Arme  {

    private String Nom;

    public Arme(){};

    public Arme(String nom){

        Nom = nom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}
