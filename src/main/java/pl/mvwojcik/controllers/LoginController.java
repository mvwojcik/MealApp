package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.mvwojcik.user.modelfx.UserFX;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class LoginController {

    @FXML
    private TextField userLoginTextField;

    @FXML
    private PasswordField userPasswordLoginTextField;

    UserFX userFX;
    @FXML
    public void initialize()
    {
        userFX = new UserFX();
        this.userLoginTextField.textProperty().bindBidirectional(this.userFX.usernameProperty());
        this.userPasswordLoginTextField.textProperty().bindBidirectional(this.userFX.passwordProperty());
    }


    @FXML
    void confirmOnAction(ActionEvent event) {
        System.out.println(userFX);
        //tutaj sprawdzenie najpier czy userFX istnieje a potem czy hasła pasują
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
