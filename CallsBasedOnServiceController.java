
package project;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class CallsBasedOnServiceController extends CommonControllerMethods{
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    @FXML
    private Button back;
    @FXML
    private Button police;
    @FXML
    private Button amb;
    @FXML
    private Button ff;
    @FXML
    private TextArea callsArea;
    @FXML
    private Button hide;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void printCallsP(ActionEvent event) throws Exception{
        txtReader reader = new txtReader("src\\project\\Calls\\Police.txt");
        
        printCalls(reader.calls);
    }

    @FXML
    private void printCallsAmb(ActionEvent event) throws Exception{
        txtReader reader = new txtReader("src\\project\\Calls\\Ambulance.txt");

        printCalls(reader.calls);
    }

    @FXML
    private void printCallsFF(ActionEvent event) throws Exception{
        txtReader reader = new txtReader("src\\project\\Calls\\Fire Fighters.txt");

        printCalls(reader.calls);
    }
    
    private void printCalls(TreeSet<String> ar){
        callsArea.setVisible(true);
        hide.setVisible(true);
        
        for(String i : ar){
            callsArea.appendText(i + "\n");
        }                
    }
    

    @FXML
    private void Hide(ActionEvent event) {
        hide.setVisible(false);
        callsArea.setVisible(false);
    }   
}
