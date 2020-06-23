package Admin;

import Utility.MakeAlert;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginFXMLController implements Initializable{

   @FXML
    private TextField tfusername;

    @FXML
    private TextField tfpass;

    @FXML
    private Button btnLogin;
    
    @FXML
    private Button btnreset;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                try{
                    Login login = new Login (tfusername.getText(), tfpass.getText());
                    if(login.login()){
                        Stage stage = (Stage) btnLogin.getScene().getWindow();
                        stage.close();
                        Parent root = FXMLLoader.load(getClass().getResource("AdminFXML.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                    else{
                        new MakeAlert(Alert.AlertType.INFORMATION,"Kesalahan Validasi","Username atau Password tidak terdaftar").show();
                    }
            } catch (IOException ex){
                Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        
        btnreset.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                tfusername.setText("");
                tfpass.setText("");
            }
        });
    }
    
}

