
package project;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.TreeSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RemoveCallController extends CommonControllerMethods{

    protected TreeMap<Integer,String> allCalls;
        
    @FXML
    private TextField num;
    @FXML
    private Button remove;
    @FXML
    private Button back;
    @FXML
    private Button hide;
    @FXML
    private TextArea callsArea;
    @FXML
    private Button police;
    @FXML
    private Button amb;
    @FXML
    private Button ff;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void removeCall(ActionEvent event) {
        int x = Integer.parseInt(num.getText());
        txtWriter writer;
        
        if(x <= allCalls.size() && x != 0){
            allCalls.remove(x);.
        
            callsArea.clear();
            printCalls(allCalls);
            num.clear();
            
            writer = new txtWriter(allCalls.get(0), allCalls);

            switch(allCalls.get(0)){
                case "Police":
                    callsArea.clear();
                    printCallsP(event);
                    break;
                case "Ambulance":
                    callsArea.clear();
                    printCallsAmb(event);
                    break;
                case "Fire Fighters":
                    callsArea.clear();
                    printCallsFF(event);
                    break;
            }
        }
        
    }

    @FXML
    private void printCallsP(ActionEvent event) {
        txtReader reader = new txtReader("src\\project\\Calls\\Police.txt");
        
        allCalls = fillTree(reader.calls, "Police");
        
        visibility();
        printCalls(allCalls);
    }

    @FXML
    private void printCallsAmb(ActionEvent event) {
        txtReader reader = new txtReader("src\\project\\Calls\\Ambulance.txt");
        
        allCalls = fillTree(reader.calls, "Ambulance");

        visibility();
        printCalls(allCalls);
    }

    @FXML
    private void printCallsFF(ActionEvent event) {
        txtReader reader = new txtReader("src\\project\\Calls\\Fire Fighters.txt");
        
        allCalls = fillTree(reader.calls, "Fire Fighters");

        visibility();
        printCalls(allCalls);
    }
    private void printCalls(TreeMap<Integer, String> ar){
        for(Integer i : ar.keySet()){
            if(i != 0){
                callsArea.appendText(i + " " + ar.get(i) + "\n");
            }            
        }
    }
    private TreeMap<Integer, String> fillTree(TreeSet<String> ar, String service){
        TreeMap<Integer, String> placeholderTree = new TreeMap<Integer, String>();
        placeholderTree.put(0, service);
        for(String i : ar){
            placeholderTree.put(placeholderTree.size(), i);
        }
        
        return placeholderTree;
    }
    
    @FXML
    private void Hide(ActionEvent event) {
        hide.setVisible(false);
        remove.setVisible(false);
        num.setVisible(false);
        callsArea.setVisible(false);
        callsArea.clear();
    }
    
    @FXML
    public void visibility(){
        hide.setVisible(true);
        remove.setVisible(true);
        num.setVisible(true);
        callsArea.setVisible(true);
    }
}
