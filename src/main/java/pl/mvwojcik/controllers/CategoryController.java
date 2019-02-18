package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class CategoryController {

    @FXML
    void breakfastOnAction(ActionEvent event) {

    }

    @FXML
    void dinnerOnAction(ActionEvent event) {

    }


    @FXML
    void snacksOnAction(ActionEvent event) {

    }

    @FXML
    void supperOnAction(ActionEvent event) {

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
