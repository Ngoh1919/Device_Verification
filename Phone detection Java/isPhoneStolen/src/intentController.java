import javafx.event.EventHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;


public class intentController  implements Initializable {
    @FXML
    private Button btn_found;

    @FXML
    private Button btn_report;

    @FXML
    private Button btn_verify;

    @Override       
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_report.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneSwitch switchScene = new sceneSwitch();
                try {
                    switchScene.switchToScene(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                
        });

        btn_found.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneSwitch switchScene = new sceneSwitch();
                try {
                    switchScene.switchToScene2(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_verify.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneSwitch switchScene = new sceneSwitch();
                try {
                    switchScene.switchToScene3(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
