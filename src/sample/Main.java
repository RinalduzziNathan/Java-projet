package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("bjr");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Guerrier G2 = new Guerrier(100,100,1,"Jj");
        Mage G1 = new Mage(50,50,1,"Knb");
        Archer archer = new Archer(50,50,1,"10",50);


        System.out.println(G2.getPv());
        archer.AttaqueArme(G2);

        System.out.println(G2.getPv());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
