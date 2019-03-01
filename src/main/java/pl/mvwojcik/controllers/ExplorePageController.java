package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class ExplorePageController {


    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;


    @FXML
    public void initialize() {

        UserToolbarUtils.initDrawer(this.drawer,this.hamburger);

    }


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
