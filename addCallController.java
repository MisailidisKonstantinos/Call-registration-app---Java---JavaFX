
package project;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.format.DateTimeFormatter;


public class addCallController extends CommonControllerMethods implements Initializable {
    
    @FXML
    private Button save;
    @FXML
    private CheckBox police;
    @FXML
    private CheckBox ambulance;
    @FXML
    private CheckBox fireFighters;
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField number;
    @FXML
    private TextArea description;
    @FXML
    private Button back;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
    }

    @FXML
    private void saveCall(ActionEvent event) {
        if(!fName.getText().isBlank() && !lName.getText().isBlank() && !number.getText().isBlank() && !description.getText().isBlank()){
            
            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            
            String call = fName.getText() + " " + lName.getText() + " " + number.getText() + ": " + date.format(now) + ", " + description.getText();
            
            if(police.isSelected()){
                txtWriter pCalls = new txtWriter("Police", call);
                police.selectedProperty().set(false);
            }
            if(ambulance.isSelected()){
                txtWriter aCalls = new txtWriter("Ambulance", call);
                ambulance.selectedProperty().set(false);
            }
            if(fireFighters.isSelected()){
                txtWriter fCalls = new txtWriter("Fire Fighters", call);
                fireFighters.selectedProperty().set(false);
            }

            fName.setText("");
            lName.setText("");
            number.setText("");
            description.setText("");
        }
    }
}
