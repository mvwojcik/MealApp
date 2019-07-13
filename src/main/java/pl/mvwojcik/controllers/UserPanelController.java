package pl.mvwojcik.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;
import static pl.mvwojcik.model.ActiveUser.user;
public class UserPanelController {

  @FXML private ImageView iconImage;

  @FXML
  void addNewMealOnAction() {}

  @FXML
  void favouritesOnAction() {}

  @FXML
  void mealPlanOnAction() {}

  @FXML
  void profileOnAction() {
    try {
      manager.stage.setScene(manager.changeScene(manager.USERPAGESCENEPATH,true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void initialize() {
    this.iconImage.setImage(new Image(this.getClass().getResource(user.getImageurl()).toString()));

  }
}
