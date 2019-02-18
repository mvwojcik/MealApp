package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class OptionsController {


    @FXML
    public void initialize()
    {languageChoiceBox.getItems().add("Polski");
    languageChoiceBox.getItems().add("Angielski");//trzeba jakoś z bundles powiązać
    currencyChoiceBox.getItems().addAll("PLN","EURO","FUNT","DOLAR");

    }



    @FXML
    void doMenu(ActionEvent event) {
        try {
            manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    private ChoiceBox<String> languageChoiceBox;

    @FXML
    private ChoiceBox<String> currencyChoiceBox;

    @FXML
    private ToggleGroup themeGroup;




}
