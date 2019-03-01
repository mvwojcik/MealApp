package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pl.mvwojcik.database.dao.UserDao;
import pl.mvwojcik.user.Converters.UserConverter;
import pl.mvwojcik.user.model.User;
import pl.mvwojcik.user.modelfx.UserFX;
import pl.mvwojcik.database.dbutils.DBManager;
import pl.mvwojcik.user.user.ActiveUser;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;
import static pl.mvwojcik.user.user.ActiveUser.user;


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

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField cpdTextField;

    @FXML
    private ComboBox<?> genderComboBox;

    UserFX userFX;


    @FXML
    public void initialize()
    {
        userFX = new UserFX();
userFX.usernameProperty().bindBidirectional(this.usernameTextField.textProperty());
userFX.passwordProperty().bindBidirectional(this.passwordTextField.textProperty());
//ttrzeba jakiegoś action listenera dać do sprawdzania czy hasła się zgadzają
userFX.emailProperty().bindBidirectional(this.emailTextField.textProperty());
userFX.calouriesProperty().set(10);
userFX.bornDateProperty().bindBidirectional(this.ageDatePicker.valueProperty());


    }

    @FXML
    void confirmOnAction(ActionEvent event) {

        userFX.genderProperty().setValue((String)this.genderComboBox.getValue());
        userFX.setHeight(182);
        userFX.setWeight(71);
        userFX.setGender("men");
        userFX.setPoints(10);

DBManager.createConnectionSource();

        DBManager.createTable();

User user = UserConverter.userFXtoUser(userFX);

        UserDao userDao = new UserDao();
        if (userDao.checkIfAvailable(userFX)) {
            userDao.create(user);
            ActiveUser.user=user;
            try {
                manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("niedostepne");
        }

        DBManager.closeConnectionSource();
        System.out.println(user);
   UserFX userfx = UserConverter.userToUserFX(user);
        System.out.println(userfx);


    }

    @FXML
    void returnOnAction(ActionEvent event) {
        try {
            manager.stage.setScene(manager.changeScene(manager.WELCOMEPAGESCENEPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
