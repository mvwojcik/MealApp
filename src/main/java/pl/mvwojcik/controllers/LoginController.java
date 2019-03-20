package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import org.apache.commons.codec.digest.DigestUtils;
import pl.mvwojcik.database.dao.UserDao;
import pl.mvwojcik.database.dbutils.DBManager;
import pl.mvwojcik.user.model.User;
import pl.mvwojcik.user.modelfx.UserFX;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;
import static pl.mvwojcik.user.user.ActiveUser.user;

public class LoginController {

  @FXML private JFXTextField userLoginTextField;

  @FXML private Label errmsglabel;
  @FXML private JFXPasswordField userPasswordLoginTextField;

  UserFX userFX;

  @FXML
  public void initialize() {
    userFX = new UserFX();
    this.userLoginTextField.textProperty().bindBidirectional(this.userFX.usernameProperty());
    this.userPasswordLoginTextField
        .textProperty()
        .bindBidirectional(this.userFX.passwordProperty());
  }

  @FXML
  void confirmOnAction() {
    DBManager.createConnectionSource();
    UserDao userDao = new UserDao();
      DigestUtils.shaHex(this.userPasswordLoginTextField.getText());

    User user1 = userDao.checkUsernameWithPassword(userFX.getUsername(),
            DigestUtils.shaHex(this.userPasswordLoginTextField.getText()));
    DBManager.closeConnectionSource();

    if (user1 != null) {
      // zaladuj usera
      user = user1;
      try {
        manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH,true));
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setHeaderText(null);
      alert.setContentText("Podano złe haslo");
      alert.showAndWait();
      this.errmsglabel.setVisible(true);
    }
  }

  @FXML
  void returnOnAction() {
    try {
      manager.stage.setScene(manager.changeScene(manager.WELCOMEPAGESCENEPATH,true));
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
