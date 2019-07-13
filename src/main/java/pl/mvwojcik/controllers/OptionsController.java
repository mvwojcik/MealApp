package pl.mvwojcik.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import pl.mvwojcik.database.dao.UserDao;
import pl.mvwojcik.model.UserSettings;
import pl.mvwojcik.utils.FXMLManager;
import pl.mvwojcik.utils.OptionsUtils;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static pl.mvwojcik.utils.FXMLManager.manager;
import static pl.mvwojcik.model.ActiveUser.user;

public class OptionsController {

    @FXML
    BorderPane borderpane;
    @FXML
    private Button minimalizeIcon;

    @FXML
    private Button fullIViewIcon;

    @FXML
    private Button exitIcon;
    ResourceBundle bundle;

    @FXML
    public void initialize() {
        UserToolbarUtils.loadTopToolbars(minimalizeIcon, fullIViewIcon, exitIcon);

        UserToolbarUtils.loadToolbars(borderpane);
        try {
            bundle = ResourceBundle.getBundle("bundles/msgs");
        } catch (MissingResourceException exception) {
            System.out.println("Bundles Error");
        }
        languageChoiceBox.getItems().addAll(UserSettings.languages);
        currencyChoiceBox.getItems().addAll(UserSettings.currencies);
    }

    @FXML
    void doMenu() {
        try {
            manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH, true));
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

    @FXML
    void confirmOnAction() {
        UserSettings userSettings = new UserSettings();
        userSettings.setCurrency(this.currencyChoiceBox.getSelectionModel().getSelectedItem());
        userSettings.setLanguage(this.languageChoiceBox.getSelectionModel().getSelectedItem());
        userSettings.setTheme(this.themeGroup.getSelectedToggle().toString());

        OptionsUtils.setLanguage(userSettings.getLanguage());
        user.setUserSettingsId(userSettings);
        try {
            manager.stage.setScene(manager.changeScene(manager.OPTIONSSCENEPATH, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // zrobic metode w userdao wrzucającą ustawienia do db potem create
        // potem to na dole  albo ogólnie zrobić kilka możliwych opcji i przypisywać ,zobzczymy
        UserDao userDao = new UserDao();
        // update
    }
}
