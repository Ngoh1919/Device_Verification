import javafx.event.EventHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class controllerFinal implements Initializable {

    @FXML
    private Label label_final,label1_final,label2_final,label3_final,label4_final;

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
    }

    public void setWarning(String[] Aa){
        if(Aa != null && Aa.length == 4){
            label_final.setText("PHONE IS STOLEN");
            label1_final.setText("Owner's Name: "+ Aa[0]);
            label2_final.setText("Owner's Name: "+ Aa[1]);
            label3_final.setText("Owner's Name: "+ Aa[2]);
            label4_final.setText("Owner's Name: "+ Aa[3]);  
        }
        else{
            System.out.println("errorrr");
        }


    }
}
