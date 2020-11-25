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

        Mage m1 = new Mage(50,50,1,"Jj");
        Mage m2 = new Mage(10,10,1,"Knb");
        m1.UtiliserSort1(m2);

        System.out.println(m1.getPv());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
