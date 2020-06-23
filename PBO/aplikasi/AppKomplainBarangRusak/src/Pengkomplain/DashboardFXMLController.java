package Pengkomplain;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DashboardFXMLController implements Initializable{

    @FXML
    private TextField tfnamalengkap;

    @FXML
    private TextField tfnamatoko;

    @FXML
    private TextField tfnamabarang;

    @FXML
    private RadioButton rbElektronik;

    @FXML
    private RadioButton rbNonElektronik;

    @FXML
    private DatePicker dpTglOrder;

    @FXML
    private TextArea takeluhan;

    @FXML
    private Button btnkirim;

    @FXML
    private Button btnbatal;

    @FXML
    private TextField tfid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}

