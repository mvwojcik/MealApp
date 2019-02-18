package pl.mvwojcik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static pl.mvwojcik.FXMLManager.manager;

public class OptionsController {

    FXMLManager fxmlmanager;
    @FXML
    public void initialzie()
    {
        fxmlmanager = manager;
    }
    @FXML
    void cofnij(ActionEvent event) {

    }

    @FXML
    void doMenu(ActionEvent event) {
        try {
            manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
