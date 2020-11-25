package sample;

public class Epee extends Arme {

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    private int degats;

    public Epee(int dgt, String nom){
        super(nom);
        degats=dgt;

    }

}
