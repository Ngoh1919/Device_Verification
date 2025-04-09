import javafx.event.EventHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class controllerVerifying1 implements Initializable {

    @FXML
    private TextField AdressMac;

    @FXML
    private Button btn_rtn;
    
    @FXML
    private Button verify_button;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_rtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneSwitch switchScene = new sceneSwitch();
                try {
                    switchScene.switchToScene4(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        verify_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String macAddress = AdressMac.getText();
                dbUtil dbutil = new dbUtil();
                String [] Aa = dbutil.searchInfo(macAddress);

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Final.fxml"));
                    Parent root = loader.load();

                    controllerFinal confin = loader.getController();
                    confin.setWarning(Aa);

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Results");
                    stage.show();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
                
            }
        });
    }


   
}
