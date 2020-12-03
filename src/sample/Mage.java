package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Mage extends Personnage {

    private ArrayList<Sort> ListSort;



    private Sort Sort1;
    private Sort SortUltime;

    //construc avec sorts par défaut et stats de base de perso
    public Mage(){
        super();
        imgClass = new Image("https://rinalduzzinathan.github.io/RinalduzziNathan/imgrpg/mage.png");
        TypePerso = "Mage";
        ListSort = new ArrayList<>();
        Sort1 = new Sort(25,10,"Court-Circuits");
        SortUltime = new Sort(75,50,"Tempete de Luden");
        ListSort.add(Sort1);
        ListSort.add(SortUltime);
    }
    //construc avec sorts par défaut et stats parametrable
    public Mage(int parampv,int parammana,int paramlvl, String paramNom){
        super(parampv,parammana,paramlvl,paramNom);
        TypePerso = "Mage";
        imgClass = new Image("https://rinalduzzinathan.github.io/RinalduzziNathan/imgrpg/mage.png");
        ListSort = new ArrayList<>();
        Sort1 = new Sort(25,10,"Court-Circuits");
        SortUltime = new Sort(75,50,"Tempete de Luden");
        ListSort.add(Sort1);
        ListSort.add(SortUltime);
    }
    //construct completement parametrable, pas de sort par défaut
    public Mage(int parampv,int parammana,int paramlvl, String paramNom, Sort sort1, Sort sortult){
        super(parampv,parammana,paramlvl,paramNom);
        imgClass = new Image("https://rinalduzzinathan.github.io/RinalduzziNathan/imgrpg/mage.png");
        TypePerso = "Mage";
        Sort1 = sort1;
        SortUltime = sortult;
        ListSort = new ArrayList<>();
        ListSort.add(Sort1);
        ListSort.add(SortUltime);
    }

    public void UtiliserSort1(Personnage cible){
        //le guerrier est le seul qui aura un calcul différent à cause du bouclier
        if(cible instanceof Guerrier){
            cible = (Guerrier)cible;
        }
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
