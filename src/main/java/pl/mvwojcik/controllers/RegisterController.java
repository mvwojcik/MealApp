package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.mvwojcik.database.dao.UserDao;
import pl.mvwojcik.user.Converters.UserConverter;
import pl.mvwojcik.user.model.User;
import pl.mvwojcik.user.modelfx.UserFX;
import pl.mvwojcik.database.dbutils.DBManager;

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

    UserFX userFX;


    @FXML
    public void initialize()
    {
        userFX = new UserFX();
userFX.usernameProperty().bindBidirectional(this.usernameTextField.textProperty());
userFX.passwordProperty().bindBidirectional(this.passwordTextField.textProperty());
//ttrzeba jakiegoś action listenera dać do sprawdzania czy hasła się zgadzają
userFX.emailProperty().bindBidirectional(this.emailTextField.textProperty());

    }

    @FXML
    void confirmOnAction(ActionEvent event) {
        System.out.println(userFX);
        //tutaj sprawdzić z db czy nie ma już takiego usera i email
        //if not -> push to db

DBManager.createConnectionSource();
//DBManager.createTable();
User user = UserConverter.userFXtoUser(userFX);

        UserDao userDao = new UserDao();
        userDao.create(user);
        DBManager.closeConnectionSource();
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
