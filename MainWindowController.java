/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainWindowController extends CommonControllerMethods{

    @FXML
    private Button addCall;
    @FXML
    private Button showService;
    @FXML
    private Button showN;
    @FXML
    private Button ch;

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void addCall(ActionEvent event) throws Exception{
        changeRoot(event, "addCall.fxml", "Add a new call");
    }
    
    @FXML
    private void callBasedOnService(ActionEvent event) throws Exception{
        changeRoot(event, "CallsBasedOnService.fxml", "Calls based on a service");
    }
    
    @FXML
    private void callBasedOnN(ActionEvent event) throws Exception{
        changeRoot(event, "CallsBasedOnN.fxml", "Calls based on a name or number");
    }
    
    @FXML
    private void removeCall(ActionEvent event) throws Exception{
        changeRoot(event, "RemoveCall.fxml", "Remove a call");
    }  
    
    @FXML
    private void charts(ActionEvent event) throws Exception{
        changeRoot(event, "charts.fxml", "Charts");
    }  
}
