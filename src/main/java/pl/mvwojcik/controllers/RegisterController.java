package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.util.converter.NumberStringConverter;
import pl.mvwojcik.database.dao.UserDao;
import pl.mvwojcik.Converters.UserConverter;
import pl.mvwojcik.user.model.User;
import pl.mvwojcik.user.modelfx.UserFX;
import pl.mvwojcik.database.dbutils.DBManager;
import pl.mvwojcik.user.user.ActiveUser;
import pl.mvwojcik.utils.DialogUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class RegisterController {

  @FXML private JFXTextField usernameTextField;

  @FXML private JFXPasswordField passwordTextField;

  @FXML private JFXPasswordField repeatPasswordTextField;

  @FXML private JFXTextField emailTextField;

  @FXML private JFXDatePicker ageDatePicker;

  @FXML private JFXTextField heightTextField;

  @FXML private JFXTextField weightTextField;

  @FXML private JFXComboBox<?> genderComboBox;

  private boolean passwordok = false;
  private boolean usernameok = false;
  private boolean emailok = false;
  private boolean weightok = false;
  private boolean heightok = false;
  private boolean genderok = false;
  private boolean borndateok = false;
  UserFX userFX;

  @FXML
  public void initialize() {
    initValidators();

    userFX = new UserFX();
    bindings();
  }

  private void bindings() {
    userFX.usernameProperty().bindBidirectional(this.usernameTextField.textProperty());
    userFX.passwordProperty().bindBidirectional(this.passwordTextField.textProperty());
    userFX.emailProperty().bindBidirectional(this.emailTextField.textProperty());
    userFX.calouriesProperty().set(10);
    userFX.bornDateProperty().bindBidirectional(this.ageDatePicker.valueProperty());
  }

  private void initValidators() {
    initGenderComboBox();
    initHeightValidator();
    initWeightValidator();
    initEmailValidator();
    initPasswordValidator();
  }

  private void initGenderComboBox() {
    List genderList = new ArrayList();
    genderList.add("man"); // tragicznie napisane trzeba mądrzej
    genderList.add("woman");
    genderComboBox.getItems().addAll(genderList);
  }

  @FXML
  void confirmOnAction() {

    if (checks()) {

      setValues();

      DBManager.createConnectionSource();

      DBManager.createTable();

      User user = UserConverter.userFXtoUser(userFX);

      UserDao userDao = new UserDao();
      if (userDao.checkIfAvailable(userFX)) {
        userDao.create(user);
        ActiveUser.user = user;
        try {
          manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH));
        } catch (IOException e) {
          e.printStackTrace();
        }
      } else {
        DialogUtils.errorDialog("Dane juz zajete");
      }

      DBManager.closeConnectionSource();
    } else {
      DialogUtils.errorDialog("Passwords aren't the same");
    }
  }

  private void setValues() {
    userFX.setGender(this.genderComboBox.getSelectionModel().getSelectedItem().toString());
    userFX.setPoints(10);
    userFX.setWeight(Double.valueOf(this.weightTextField.getText()));
    userFX.setHeight(Double.valueOf(this.weightTextField.getText()));
    userFX.setCalouries(0);
    if ((userFX.getGender().equals("man"))) {
      userFX.setIconURL("/images/man1.png");
    } else {
      userFX.setIconURL("/images/woman1.png");
    }
  }

  private boolean checks() {
    return this.emailTextField.validate()
        && this.heightTextField.validate()
        && this.weightTextField.validate()
        && passwordok;
  }

  @FXML
  void returnOnAction() {
    try {
      manager.stage.setScene(manager.changeScene(manager.WELCOMEPAGESCENEPATH));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void initHeightValidator() {
    NumberValidator numberValidator = new NumberValidator();
    heightTextField.getValidators().add(numberValidator);

    numberValidator.setMessage("Only number form 10-250");

    heightTextField
        .focusedProperty()
        .addListener(
            new ChangeListener<Boolean>() {
              @Override
              public void changed(
                  ObservableValue<? extends Boolean> observable,
                  Boolean oldValue,
                  Boolean newValue) {
                if (!newValue) {
                  if (heightTextField.validate()) {
                    Integer.valueOf(heightTextField.getText());
                  }
                }
              }
            });
  }

  private void initWeightValidator() {
    NumberValidator numberValidator = new NumberValidator();
    weightTextField.getValidators().add(numberValidator);

    numberValidator.setMessage("Only number form 10-150");

    weightTextField
        .focusedProperty()
        .addListener(
            new ChangeListener<Boolean>() {
              @Override
              public void changed(
                  ObservableValue<? extends Boolean> observable,
                  Boolean oldValue,
                  Boolean newValue) {
                if (!newValue) {
                  if (weightTextField.validate()) {
                    System.out.println("jazda"); // Integer.valueOf(heightTextField.getText());
                  }
                }
              }
            });
  }

  private void initEmailValidator() {
    RegexValidator emailValidator = new RegexValidator();
    emailValidator.setRegexPattern(".+@.+\\..+");

    emailValidator.setMessage("Enter proper email");

    this.emailTextField.getValidators().add(emailValidator);
    this.emailTextField
        .focusedProperty()
        .addListener(
            new ChangeListener<Boolean>() {
              @Override
              public void changed(
                  ObservableValue<? extends Boolean> observable,
                  Boolean oldValue,
                  Boolean newValue) {
                if (!newValue) {
                  emailTextField.validate();
                }
              }
            });
  }
//to trzeba sie dostac jakos do tego tekstu pod jfxtextfield
  private void initPasswordValidator() {
    RequiredFieldValidator validator = new RequiredFieldValidator();
    validator.setMessage("Passwords aren't the same");
    this.repeatPasswordTextField.getValidators().add(validator);
    this.repeatPasswordTextField
        .focusedProperty()
        .addListener(
            new ChangeListener<Boolean>() {
              @Override
              public void changed(
                  ObservableValue<? extends Boolean> observable,
                  Boolean oldValue,
                  Boolean newValue) {

                if (repeatPasswordTextField.getText().equals(passwordTextField.getText())
                    && repeatPasswordTextField.getText().length() != 0) {
                  passwordok = true;
                } else {
                  passwordok = false;
                }
              }
            });
  }
}
