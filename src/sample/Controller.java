package sample;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    Image mageImg;
    Image archerImg;
    Image guerrierImg;


    Personnage persoCree;



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
                    writer.write(persoCree.getNom());
                    writer.write("\n");
                    writer.write( Integer.toString(persoCree.getPv()));
                    writer.write("\n");
                    writer.write(Integer.toString(persoCree.getPvMax()));
                    writer.write("\n");
                    writer.write(Integer.toString(persoCree.getMana()));
                    writer.write("\n");
                    writer.write(Integer.toString(persoCree.getManaMax()));
                    writer.write("\n");
                    writer.write(Integer.toString(persoCree.getLvl()));
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
    public void OpenFile(){
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(stage);
    }

}
