package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.mvwojcik.user.model.User;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class LoginController {

    @FXML
    private TextField userLoginTextField;

    @FXML
    private PasswordField userPasswordLoginTextField;

    User user;
    @FXML
    public void initialize()
    {
        user = new User();
        this.userLoginTextField.textProperty().bindBidirectional(this.user.usernameProperty());
        this.userPasswordLoginTextField.textProperty().bindBidirectional(this.user.passwordProperty());
    }


    @FXML
    void confirmOnAction(ActionEvent event) {
        System.out.println(user);
        //tutaj sprawdzenie najpier czy user istnieje a potem czy hasła pasują
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
