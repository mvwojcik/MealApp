package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class ExplorePageController {


    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private GridPane gridPane;

    @FXML
    public void initialize() {

        UserToolbarUtils.initDrawer(this.drawer,this.hamburger);

        try {
            gridPane.add(FXMLLoader.load(ExplorePageController.class.getClass().getResource("/fxml/Content.fxml")),0,0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            gridPane.add(FXMLLoader.load(ExplorePageController.class.getClass().getResource("/fxml/Content.fxml")),0,1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

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
