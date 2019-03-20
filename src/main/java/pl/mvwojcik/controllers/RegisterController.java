package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.converter.NumberStringConverter;
import org.apache.commons.codec.digest.DigestUtils;
import pl.mvwojcik.database.dao.UserDao;
import pl.mvwojcik.Converters.UserConverter;
import pl.mvwojcik.user.model.User;
import pl.mvwojcik.user.modelfx.UserFX;
import pl.mvwojcik.database.dbutils.DBManager;
import pl.mvwojcik.user.user.ActiveUser;
import pl.mvwojcik.utils.DialogUtils;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class RegisterController {

  UserFX userFX;
  @FXML private JFXTextField usernameTextField;
  @FXML private JFXPasswordField passwordTextField;
  @FXML private JFXPasswordField repeatPasswordTextField;
  @FXML private JFXTextField emailTextField;
  @FXML private JFXDatePicker ageDatePicker;
  @FXML private JFXTextField heightTextField;
  @FXML private JFXTextField weightTextField;
  @FXML private JFXComboBox<?> genderComboBox;

  @FXML
  private Button minimalizeIcon;

  @FXML
  private Button fullIViewIcon;

  @FXML
  private Button exitIcon;

  private boolean passwordok = false;
  private boolean usernameok = false;
  private boolean emailok = false;
  private boolean weightok = false;
  private boolean heightok = false;
  private boolean genderok = false;
  private boolean borndateok = false;

  @FXML
  public void initialize() {
    initValidators();
    UserToolbarUtils.loadTopToolbars(minimalizeIcon,fullIViewIcon,exitIcon);

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
    initRepeatPasswordValidator();
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

      userFX.setPassword(DigestUtils.shaHex(this.passwordTextField.getText()));
      User user = UserConverter.userFXtoUser(userFX);

      UserDao userDao = new UserDao();
      if (userDao.checkIfAvailable(userFX)) {
        userDao.create(user);
        ActiveUser.user = user;
        try {
          manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH, true));
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
    userFX.setHeight(Double.valueOf(this.heightTextField.getText()));
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
        && this.repeatPasswordTextField.validate();
  }

  @FXML
  void returnOnAction() {
    try {
      manager.stage.setScene(manager.changeScene(manager.WELCOMEPAGESCENEPATH, true));
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
            (observable, oldValue, newValue) -> {
              if (!newValue) {
                if (heightTextField.validate()) {
                  Integer.valueOf(heightTextField.getText());
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
            (observable, oldValue, newValue) -> {
              if (!newValue) {
                if (weightTextField.validate()) {
                  System.out.println("jazda"); // Integer.valueOf(heightTextField.getText());
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
            (observable, oldValue, newValue) -> {
              if (!newValue) {
                emailTextField.validate();
              }
            });
  }
  // to trzeba sie dostac jakos do tego tekstu pod jfxtextfield
  private void initRepeatPasswordValidator() {
    RegexValidator validator = new RegexValidator();

    validator.setMessage("Passwords aren't the same");
    this.repeatPasswordTextField.getValidators().add(validator);
    this.repeatPasswordTextField
        .focusedProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              validator.setRegexPattern(passwordTextField.getText());

              if (!newValue) {
                repeatPasswordTextField.validate();
              }
            });
  }

  public void initPasswordValidator() {
    this.passwordTextField
        .focusedProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              if (!newValue) {
                if (repeatPasswordTextField.getText().length() != 0) {
                  ((RegexValidator) repeatPasswordTextField.getValidators().get(0))
                      .setRegexPattern(passwordTextField.getText());
                  repeatPasswordTextField.validate();
                }
              }
            });
  }
}
