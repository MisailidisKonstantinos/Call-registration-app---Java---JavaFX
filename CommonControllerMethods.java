
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommonControllerMethods implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    protected void changeRoot(ActionEvent event, String newRoot, String title) throws Exception{ 
        Parent root = FXMLLoader.load(getClass().getResource(newRoot));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();        
        scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    protected void goBack(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Main Window");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


