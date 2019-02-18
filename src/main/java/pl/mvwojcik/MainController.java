package pl.mvwojcik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static pl.mvwojcik.FXMLManager.manager;



public class MainController  {
    public static MainController controller;
    public FXMLManager fxmlManager;
    @FXML
    public void initialize()
    {
        this.fxmlManager=manager;
    }
    @FXML
    public void optionsOnClick(ActionEvent event) {

        try {
            manager.stage.setScene(manager.changeScene(manager.OPTIONSSCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
