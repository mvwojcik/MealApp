package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.mvwojcik.database.dao.UserDao;
import pl.mvwojcik.database.dbutils.DBManager;
import pl.mvwojcik.user.Converters.UserConverter;
import pl.mvwojcik.user.model.User;
import pl.mvwojcik.user.modelfx.UserFX;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class LoginController {

    @FXML
    private TextField userLoginTextField;


    @FXML
    private Label errmsglabel;


    @FXML
    private PasswordField userPasswordLoginTextField;

    UserFX userFX;

    @FXML
    public void initialize() {
        userFX = new UserFX();
        this.userLoginTextField.textProperty().bindBidirectional(this.userFX.usernameProperty());
        this.userPasswordLoginTextField.textProperty().bindBidirectional(this.userFX.passwordProperty());
    }


    @FXML
    void confirmOnAction(ActionEvent event) {
        System.out.println(userFX);

        DBManager.createConnectionSource();
        UserDao userDao = new UserDao();

        User user = userDao.checkUsernameWithPassword(userFX.getUsername(), userFX.getPassword());
        DBManager.closeConnectionSource();

        if (user != null) {
            System.out.println("dziala");
            //zaladuj usera
            this.returnOnAction();
        } else {
            this.errmsglabel.setVisible(true);
        }
        //tutaj sprawdzenie najpier czy userFX istnieje a potem czy hasła pasują


    }

    @FXML
    void returnOnAction() {
        try {
            manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void forgotPasswordOnAction(ActionEvent event) {
        DBManager.createConnectionSource();
        UserDao userDao = new UserDao();
        User user = userDao.findByUsername(userFX.getUsername());
        if (user != null) {
            System.out.println("mozna wyslac maila z przypomnieniem, gdzies jest taka bibliteka na bank");
        }

        DBManager.closeConnectionSource();
    }
}
