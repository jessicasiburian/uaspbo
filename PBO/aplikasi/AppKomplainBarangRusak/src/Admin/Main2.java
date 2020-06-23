/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Pengkomplain.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ITD
 */
public class Main2 extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }catch(Exception e){
        e.printStackTrace();
    }
}
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
