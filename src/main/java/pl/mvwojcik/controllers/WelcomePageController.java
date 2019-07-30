package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pl.mvwojcik.database.dbutils.DBManager;
import pl.mvwojcik.model.User;
import pl.mvwojcik.utils.OptionsUtils;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;
import static pl.mvwojcik.model.ActiveUser.user;

public class WelcomePageController {

  @FXML private Button minimalizeIcon;

  @FXML private Button fullIViewIcon;

  @FXML private Button exitIcon;

  @FXML
  public void initialize() {    UserToolbarUtils.loadTopToolbars(minimalizeIcon,fullIViewIcon,exitIcon);
  }


  @FXML
  void loginOnAction() {

    try {
      manager.stage.setScene(manager.changeScene(manager.LOGINSCENEPATH, true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  void registerOnAction() {

    try {
      manager.stage.setScene(manager.changeScene(manager.REGISTERSCENEPATH, true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  void trialOnAction() {
    try {
      manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH, true));
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
  @FXML
  void changeLanguage(ActionEvent event) {
    OptionsUtils.setLanguage(((Button)event.getSource()).getText());
    try {
      manager.stage.setScene(manager.changeScene(manager.WELCOMEPAGESCENEPATH,true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
