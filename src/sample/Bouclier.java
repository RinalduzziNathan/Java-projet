package sample;

public class Bouclier extends Arme {


    private int ReductionBrute;

    public Bouclier(int reducVal, String nom){
        super(nom);
        ReductionBrute = reducVal;
    }

    public int getReductionBrute() {
        return ReductionBrute;
    }

    public void setReductionBrute(int reductionBrute) {
        ReductionBrute = reductionBrute;
    }

}
