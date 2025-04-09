import javafx.event.EventHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class controllerVerifying implements Initializable {

    @FXML
    private TextField macAInput;

    @FXML
    private Button find_button;
    
    @FXML
    private Button btn_return;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_return.setOnAction(new EventHandler<ActionEvent>() {
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
        find_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String macAddress = macAInput.getText();
                dbUtil dbutil = new dbUtil();
                dbutil.markFound(macAddress);
            }
        });
    }
}
