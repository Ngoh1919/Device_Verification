import javafx.event.EventHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class controllerReporting implements Initializable {

    @FXML
    private TextField f_name, s_name, o_id, device_name, mac_adress,o_id1;

    @FXML
    private Button report_button, rt_bt;
    


    public void initialize(URL url, ResourceBundle resourceBundle) {
        rt_bt.setOnAction(new EventHandler<ActionEvent>() {
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

        report_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String firstName = f_name.getText();
                String lastName = s_name.getText();
                String ownerId = o_id.getText();
                String deviceName = device_name.getText();
                String deviceId = mac_adress.getText();
                String deviceType = o_id1.getText(); // Assuming the device type is always "phone"

                phoneInfo phoneinfo = new phoneInfo(firstName, lastName, ownerId, deviceName, deviceId, deviceType);
                dbUtil dbutil = new dbUtil();
                dbutil.addInfo(phoneinfo);
            }
        });
    }
}