package sample;

import java.util.ArrayList;

public class Archer extends Personnage {

    ArrayList<Arme> ListArme;
    private  Arc arc;
    private int nbFleche;


    public Archer(){
        super();
        TypePerso = "Archer";
        nbFleche =5;
        ListArme = new ArrayList<>();
        arc= new Arc(45,"Bow");

        ListArme.add(arc);
    }

    public Archer(int parampv,int parammana,int paramlvl, String paramNom, int nbfleche){
        super(parampv,parammana,paramlvl,paramNom);
        TypePerso = "Archer";
        nbFleche =nbfleche;
        ListArme = new ArrayList<>();
        arc= new Arc(45,"Bow");

        ListArme.add(arc);
    }

    public Archer(int parampv,int parammana,int paramlvl, String paramNom, int nbfleche, Arc paramArc){
        super(parampv,parammana,paramlvl,paramNom);
        TypePerso = "Archer";
        nbFleche =nbfleche;
        ListArme = new ArrayList<>();
        arc= paramArc;

        ListArme.add(arc);
    }

    //attaquer à l'arme
    void AttaqueArme(Personnage cible){
        //le guerrier est le seul qui aura un calcul différent à cause du bouclier
        if(cible instanceof Guerrier){
            cible = (Guerrier)cible;
        }
        cible.PrendreDesDegats(arc.getDegats());
        nbFleche--;
    }

}
