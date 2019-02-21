package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.mvwojcik.user.model.User;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class RegisterController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private PasswordField repeatPasswordTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private DatePicker ageDatePicker;

    @FXML
    private Label usernameSign;

    @FXML
    private Label ageLabel;

    User user;


    @FXML
    public void initialize()
    {
        user = new User();
user.usernameProperty().bindBidirectional(this.usernameTextField.textProperty());
user.passwordProperty().bindBidirectional(this.passwordTextField.textProperty());
//ttrzeba jakiegoś action listenera dać do sprawdzania czy hasła się zgadzają
user.emailProperty().bindBidirectional(this.emailTextField.textProperty());

    }

    @FXML
    void confirmOnAction(ActionEvent event) {
        System.out.println(user);
        //tutaj sprawdzić z db czy nie ma już takiego usera i email
        //if not -> push to db
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
