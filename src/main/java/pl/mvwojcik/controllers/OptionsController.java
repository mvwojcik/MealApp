package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class OptionsController {


    @FXML
    public void initialize()
    {
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
