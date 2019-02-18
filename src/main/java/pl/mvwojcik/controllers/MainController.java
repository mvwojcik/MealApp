package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pl.mvwojcik.utils.FXMLManager;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;



public class MainController  {
    public FXMLManager fxmlManager;
    @FXML
    public void initialize()
    {
        this.fxmlManager=manager;
    }



    @FXML
    void exploreOnAction(ActionEvent event) {
        try {
            manager.stage.setScene(manager.changeScene(manager.EXPLORESCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void registerOnAction(ActionEvent event) {

        try {
            manager.stage.setScene(manager.changeScene(manager.REGISTERSCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void signUpOnAction(ActionEvent event) {

        try {
            manager.stage.setScene(manager.changeScene(manager.LOGINSCENEPATH));
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
