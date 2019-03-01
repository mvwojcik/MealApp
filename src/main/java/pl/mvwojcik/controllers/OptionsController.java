package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleGroup;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class OptionsController {

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;


    @FXML
    public void initialize()
    {
        UserToolbarUtils.initDrawer(drawer,hamburger);
    languageChoiceBox.getItems().add("Polski");
    languageChoiceBox.getItems().add("Angielski");//trzeba jakoś z bundles powiązać
    currencyChoiceBox.getItems().addAll("PLN","EURO","FUNT","DOLAR");

    }



    @FXML
    void doMenu() {
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
