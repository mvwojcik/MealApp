package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class ExplorePageController {

    @FXML
    void backOnAction(ActionEvent event) {
        try {
            manager.stage.setScene(manager.changeScene(manager.EXPLORESCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void returnOnAction(ActionEvent event) {
        try {
            manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
