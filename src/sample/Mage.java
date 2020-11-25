package sample;

public class Mage extends Personnage {





    private Sort Sort1;
    private Sort SortUltime;

    //construc avec sorts par défaut et stats de base de perso
    public Mage(){
        super();
        Sort1 = new Sort(25,10,"Court-Circuits");
        SortUltime = new Sort(75,50,"Tempete de Luden");
    }
    //construc avec sorts par défaut et stats parametrable
    public Mage(int parampv,int parammana,int paramlvl, String paramNom){
        super(parampv,parammana,paramlvl,paramNom);
        Sort1 = new Sort(25,10,"Court-Circuits");
        SortUltime = new Sort(75,50,"Tempete de Luden");
    }
    //construct completement parametrable, pas de sort par défaut
    public Mage(int parampv,int parammana,int paramlvl, String paramNom, Sort sort1, Sort sortult){
        super(parampv,parammana,paramlvl,paramNom);
        Sort1 = sort1;
        SortUltime = sortult;
    }

    public void UtiliserSort1(Personnage cible){
        cible.PrendreDesDegats(Sort1.getDegats());
        this.UtiliserMana(Sort1.getCoutMana());
    }


    public void UtiliserSortUltime(Personnage cible){
        cible.PrendreDesDegats(SortUltime.getDegats());
        this.UtiliserMana(SortUltime.getCoutMana());
    }

    void GagnerNiveau(){
        System.out.println("Mage gagne niv");
        this.setPvMax(getPvMax()+25);
        this.setManaMax(getManaMax()+75);
    }


    public Sort getSort1() {
        return Sort1;
    }

    public void setSort1(Sort sort1) {
        Sort1 = sort1;
    }
    public Sort getSortUltime() {
        return SortUltime;
    }

    public void setSortUltime(Sort sortUltime) {
        SortUltime = sortUltime;
    }

}
