package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pl.mvwojcik.utils.FXMLManager;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;



public class MainController  {
    public static MainController controller;
    public FXMLManager fxmlManager;
    @FXML
    public void initialize()
    {
        this.fxmlManager=manager;
    }



    @FXML
    void exploreOnAction(ActionEvent event) {
    }

    @FXML
    void registerOnAction(ActionEvent event) {

        //otwieramy scene do rejestracji

    }

    @FXML
    void signUpOnAction(ActionEvent event) {

        //otwieramy scene do logowania

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
