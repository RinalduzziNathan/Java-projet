package sample;

public class Arc extends Arme{



    private int degats;

    public Arc(int dgt, String nom){
        super(nom);
        degats=dgt;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

}
