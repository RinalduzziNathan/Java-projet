package sample;

import java.util.ArrayList;

public class Guerrier extends Personnage {

    ArrayList<Arme> ListArme;
    private  Bouclier bouclier;
    private  Epee epee;


    public Guerrier(){
        super();
        ListArme = new ArrayList<>();
        bouclier= new Bouclier(5,"Doran Shield");
        epee = new  Epee(17,"Doran Sword");
        ListArme.add(epee);
        ListArme.add(bouclier);
    }
    public Guerrier(int parampv, int parammana, int paramlvl, String paramNom){
        super(parampv,parammana,paramlvl,paramNom);
        ListArme = new ArrayList<>();
        bouclier= new Bouclier(5,"Doran Shield");
        epee = new  Epee(17,"Doran Sword");
        ListArme.add(epee);
        ListArme.add(bouclier);
    }

    //attaquer à l'arme
    void AttaqueArme(Personnage cible){
        //le guerrier est le seul qui aura un calcul différent à cause du bouclier
        if(cible instanceof Guerrier){
            cible = (Guerrier)cible;
        }
        cible.PrendreDesDegats(epee.getDegats());
    }


    //redéfinition de la fct pour prendre des dégats vu que le guerrier a un bouclier
    boolean PrendreDesDegats(int degats){

        //Si le joueur est mort
        if((this.getPv()+bouclier.getReductionBrute())-degats<=0){
            this.setPv(0);
            System.out.println("JOUEUR " + this.getNom() + " EST MORT ");
            return false;
        }else {
            this.setPv((this.getPv()+bouclier.getReductionBrute()) - degats);
            return  true;
        }
    }

}
