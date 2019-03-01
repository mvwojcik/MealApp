package pl.mvwojcik.controllers;

import javafx.fxml.FXML;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;
import static pl.mvwojcik.user.user.ActiveUser.user;


public class UserPanelController {
    @FXML
    void addNewMealOnAction() {

    }

    @FXML
    void favouritesOnAction() {

    }

    @FXML
    void mealPlanOnAction() {

    }

    @FXML
    void profileOnAction() {
        try {
            manager.stage.setScene(manager.changeScene(manager.USERPAGESCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
