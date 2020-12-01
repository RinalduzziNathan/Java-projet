package sample;
import javafx.scene.control.TextField;
import java.io.IOException;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Controller {
    @FXML
    Pane panePerso;
    @FXML
    Pane paneJouer;
    @FXML
    TextField nomPerso;

    Personnage persoCree;


    @FXML
    public void CreationPerso(){
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
        paneJouer.setVisible(false);
        panePerso.setVisible(false);
    }

    @FXML
    public void CreateMage(){
        System.out.println(nomPerso.getText());

        //persoCree = new Mage(100,100,1,nomDuPerso.getName());
    }
    @FXML
    public void CreateArcher(){
        //persoCree = new Archer(100,100,1,nomDuPerso.getName(),5);
    }

    @FXML
    public void CreateGuerrier(){
        //persoCree = new Guerrier(100,100,1,nomDuPerso.getName());
    }




}
