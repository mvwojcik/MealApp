package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class ExplorePageController {


    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawersStack drawerStack;

    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXDrawer drawer;


    @FXML
    public void initialize() {
        initdrawer();
    }

    private void initdrawer() {

        try {
            VBox toolbar = FXMLLoader.load(getClass().getResource("/fxml/UserPanel.fxml"));
            drawer.setSidePane(toolbar);

drawer.setDefaultDrawerSize(100);
            toolbar.autosize();

        } catch (IOException e) {
            e.printStackTrace();
        }
        final HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {

            task.setRate(task.getRate() * -1);
            task.play();
            if (drawer.isClosed()) {
                drawer.open();

            } else {
                drawer.close();
            }
        });


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
