package sample;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Controller {
    @FXML
    Pane panePerso;
    @FXML
    Pane paneJouer;
    @FXML
    TextField nomPerso;
    @FXML
    Button sauvegarder;
    @FXML
    ImageView mage;
    @FXML
    ImageView archer;
    @FXML
    ImageView guerrier;

     @FXML
    Label JoueurNom;
    @FXML
    Label vieJoueur;
    @FXML
    Label manaJoueur;
    @FXML
    Label lvlJoueur;

    @FXML
    Label adversaireNom;
    @FXML
    Label vieEnnemie;
    @FXML
    Label manaEnnemie;
    @FXML
    Label lvlEnnemie;


    @FXML
    ImageView imageAllie;
    @FXML
    ImageView imageEnnemie;



    Image mageImg;
    Image archerImg;
    Image guerrierImg;

    //variable gerant le personnage crée dans le menu crée le perso
    Personnage persoCree;

    //variable gerant le joueur, est chargée depuis un fichier txt et remplie suivant les caractéristiques du fichier
    Personnage Joueur;
    //variable gerant l'adversaire
    Personnage Adversaire;



    @FXML
    public void CreationPerso(){
        //action du bouton pour créer des personnages
        System.out.println(panePerso.getId());
        panePerso.setVisible(true);
        paneJouer.setVisible(false);
    }
    @FXML
    public void ButtonJouer(){
        System.out.println(paneJouer.getId());
        paneJouer.setVisible(true);
        panePerso.setVisible(false);
    }

    @FXML
    public void initialize() {
        //initialisation des images
        mageImg = new Image("https://rinalduzzinathan.github.io/RinalduzziNathan/imgrpg/mage.png");
        mage.setImage(mageImg);
        archerImg = new Image("https://rinalduzzinathan.github.io/RinalduzziNathan/imgrpg/archer.png");
        archer.setImage(archerImg);
        guerrierImg = new Image("https://rinalduzzinathan.github.io/RinalduzziNathan/imgrpg/guerrier.png");
        guerrier.setImage(guerrierImg);
        paneJouer.setVisible(false);
        panePerso.setVisible(false);
    }

    @FXML
    public void CreateMage(){
        sauvegarder.setDisable(false);
        persoCree = new Mage(100,100,1,nomPerso.getText());
    }
    @FXML
    public void CreateArcher(){
        sauvegarder.setDisable(false);
        persoCree = new Archer(100,100,1,nomPerso.getText(),5);
    }

    @FXML
    public void CreateGuerrier(){
        sauvegarder.setDisable(false);
        persoCree = new Guerrier(100,100,1,nomPerso.getText());
    }


    @FXML //bouton pour sauvegarder un perso ds un fichier
    public void CreateFile (){
        sauvegarder.setDisable(true);//après avoir créer un perso, re disable le bouton
        try {
            File persoFichier = new File( "perso/"+persoCree.getNom()+".txt");
                if (persoFichier.createNewFile()) {
                    FileWriter writer = new FileWriter(persoFichier.getPath());

                    writer.write(persoCree.getTypePerso());
                    writer.write("\n");
                    writer.write( Integer.toString(persoCree.getPv()));
                    writer.write("\n");
                    writer.write(Integer.toString(persoCree.getMana()));
                    writer.write("\n");
                    writer.write(Integer.toString(persoCree.getLvl()));
                    writer.write("\n");
                    writer.write(persoCree.getNom());
                    writer.write("\n");
                    writer.close();
                }
                else {
                    System.out.println("File already exists."); }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }

    @FXML
    public void OpenFile() throws FileNotFoundException {
        //s'assurer que le joueur est nul
        Joueur = null;
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ouvrir un perso .txt");
        fileChooser.setInitialDirectory(new File("perso"));
        File myObj = fileChooser.showOpenDialog(stage);
        Scanner myReader = new Scanner(myObj);

        //lire le fichier choisi et le sauvegarder dans un arrayList
        ArrayList<String> InfoFichier = new ArrayList<>();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            InfoFichier.add(data);
        }

        //créer le joueur suivant sa class
        if(InfoFichier.get(0).equals("Guerrier")){
            Joueur= new Guerrier(Integer.parseInt(InfoFichier.get(1)),Integer.parseInt(InfoFichier.get(2)),Integer.parseInt(InfoFichier.get(3)),InfoFichier.get(4));
            imageAllie.setImage(Joueur.getImg());


        }else if(InfoFichier.get(0).equals("Mage")){
            Joueur= new Mage(Integer.parseInt(InfoFichier.get(1)),Integer.parseInt(InfoFichier.get(2)),Integer.parseInt(InfoFichier.get(3)),InfoFichier.get(4));
            imageAllie.setImage(Joueur.getImg());
        }else if(InfoFichier.get(0).equals("Archer")){

            Joueur= new Archer(Integer.parseInt(InfoFichier.get(1)),Integer.parseInt(InfoFichier.get(2)),Integer.parseInt(InfoFichier.get(3)),InfoFichier.get(4),5);
            imageAllie.setImage(Joueur.getImg());
        }
        JoueurNom.setText(Joueur.getNom());
        vieJoueur.setText(String.valueOf(Joueur.getPv()));
        manaJoueur.setText(String.valueOf(Joueur.getMana()));
        lvlJoueur.setText(String.valueOf(Joueur.getLvl()));

    }

    @FXML
    public void GenererEnnemie(){
        Adversaire = new Archer(150,50,1,"Serylda",4);
        imageEnnemie.setImage(Adversaire.getImg());
        adversaireNom.setText(Adversaire.getNom());
        vieEnnemie.setText(String.valueOf(Adversaire.getPv()));
        manaEnnemie.setText(String.valueOf(Adversaire.getMana()));
        lvlEnnemie.setText(String.valueOf(Adversaire.getLvl()));

    }

    @FXML
    public void fight(){



    }



}
