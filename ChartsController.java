
package project;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChartsController extends CommonControllerMethods{

    @FXML
    private Button back;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private PieChart pChart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtReader reader = new txtReader("src\\project\\Calls\\Police.txt");
        txtReader reader2 = new txtReader("src\\project\\Calls\\Ambulance.txt");
        txtReader reader3 = new txtReader("src\\project\\Calls\\Fire Fighters.txt");
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        float pCalls = reader.calls.size();
        float aCalls = reader2.calls.size();
        float fCalls = reader3.calls.size();
        float tCalls = pCalls + aCalls + fCalls;
        
        ObservableList<PieChart.Data> pChartData = FXCollections.observableArrayList(
                new PieChart.Data("Police: " + String.valueOf(df.format((pCalls / tCalls) * 100)) + "%", reader.calls.size()),
                new PieChart.Data("Ambulance: " + String.valueOf(df.format((aCalls / tCalls) * 100)) + "%", reader2.calls.size()),
                new PieChart.Data("Fire Fighters: " + String.valueOf(df.format((fCalls / tCalls) * 100)) + "%", reader3.calls.size())
        );
        
        pChart.setData(pChartData);
    }       
}
