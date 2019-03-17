package pl.mvwojcik.controllers;

import javafx.fxml.FXML;
import pl.mvwojcik.database.dbutils.DBManager;
import pl.mvwojcik.user.model.User;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;
import static pl.mvwojcik.user.user.ActiveUser.user;

public class WelcomePageController {
  @FXML
  public void initialize() {}

  @FXML
  void loginOnAction() {

    try {
      manager.stage.setScene(manager.changeScene(manager.LOGINSCENEPATH,true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  void registerOnAction() {

    try {
      manager.stage.setScene(manager.changeScene(manager.REGISTERSCENEPATH,true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  void trialOnAction() {
    try {
      manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH,true));
      User trialUser = new User();
      trialUser.setUsername("trialUser");
      trialUser.setPoints(0);
      user = trialUser;
      DBManager.createConnectionSource();
      DBManager.closeConnectionSource();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
