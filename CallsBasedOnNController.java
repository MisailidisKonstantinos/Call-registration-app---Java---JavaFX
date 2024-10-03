
package project;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class CallsBasedOnNController extends CommonControllerMethods{
    protected TreeSet<String> allCalls = new TreeSet<String>();
    protected String search;
    
    @FXML
    private Button show;
    @FXML
    private Button back;
    @FXML
    private TextField input;
    @FXML
    private TextArea callsArea;
    @FXML
    private Button hide;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void printCalls(ActionEvent event) {
        search = input.getText();
        input.clear();
        
        txtReader policeReader = new txtReader("src\\project\\Calls\\Police.txt");
        txtReader ambReader = new txtReader("src\\project\\Calls\\Ambulance.txt");
        txtReader ffReader = new txtReader("src\\project\\Calls\\Fire Fighters.txt");
        
        if(!search.isEmpty()){
            callsArea.setVisible(true);
            
            for(String i : policeReader.calls){
                if(i.contains(search)){
                    allCalls.add(i + " : Police");
                }
            }
            
            for(String i : ambReader.calls){
                if(i.contains(search)){
                    allCalls.add(i + " : Ambulance");
                }
            }
                       
            for(String i : ffReader.calls){
                if(i.contains(search)){
                    allCalls.add(i + " : Fire fighters");
                }
            }
                  
            for(String i : allCalls){
                callsArea.appendText(i + "\n");
            }
            
            show.setVisible(false);
            hide.setVisible(true);
        }
        
        
    }

    @FXML
    private void Hide(ActionEvent event) {
        show.setVisible(true);
        hide.setVisible(false);
        callsArea.setVisible(false);
        callsArea.clear();
        allCalls.clear();
    }
      
}
