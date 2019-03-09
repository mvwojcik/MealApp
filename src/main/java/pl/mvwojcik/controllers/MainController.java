package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import pl.mvwojcik.utils.FXMLManager;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;
import static pl.mvwojcik.user.user.ActiveUser.user;



public class MainController  {
    @FXML
    private BorderPane borderpane;

    public FXMLManager fxmlManager;

    @FXML
    public void initialize()
    {

        this.fxmlManager=manager;
        UserToolbarUtils.loadToolbars(borderpane);

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
