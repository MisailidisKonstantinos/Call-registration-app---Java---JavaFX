
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInController extends CommonControllerMethods{

    @FXML
    private TextField name;
    @FXML
    private PasswordField pass;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void logIn(ActionEvent event) throws Exception{
        if(name.getText().toLowerCase().equals("admin") && pass.getText().equals("adminpass")){
            changeRoot(event, "mainWindow.fxml", "Main Window"); //Κατευθύνει τον χρήστη στο mainWindow.fxml μετά την επιτυχή σύνδεση.
        }
    }
}
