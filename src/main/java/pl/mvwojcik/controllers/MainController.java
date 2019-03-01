package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pl.mvwojcik.utils.FXMLManager;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;



public class MainController  {
    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;


    public FXMLManager fxmlManager;

    @FXML
    public void initialize()
    {
        this.fxmlManager=manager;
        UserToolbarUtils.initDrawer(this.drawer,this.hamburger);
    }



    @FXML
    void exploreOnAction() {
        try {
            manager.stage.setScene(manager.changeScene(manager.EXPLORESCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void optionsOnClick(ActionEvent event) {

        try {
            manager.stage.setScene(manager.changeScene(manager.OPTIONSSCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void exitOnClick(ActionEvent event) {
        manager.getStage().close();
        //tutaj okienko dialogowe
    }


}
