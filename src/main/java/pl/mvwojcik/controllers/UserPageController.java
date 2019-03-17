package pl.mvwojcik.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.mvwojcik.Converters.UserConverter;
import pl.mvwojcik.user.modelfx.UserFX;

import java.io.IOException;

import static pl.mvwojcik.user.user.ActiveUser.user;
import static pl.mvwojcik.utils.FXMLManager.manager;

public class UserPageController {

  @FXML private Label username;

  @FXML private Label email;

  @FXML private Label age;

  @FXML private Label weight;

  @FXML private Label height;

  @FXML private Label calories;

  @FXML private Label points;

  @FXML private ImageView avatarImage;

  @FXML
  public void initialize() {
    System.out.println(user.getWeight());
    System.out.println(user.getHeight());
    UserFX userfx = UserConverter.userToUserFX(user);
    this.username.setText(userfx.getUsername());
    this.email.setText(userfx.getEmail());
    this.weight.setText(Double.toString(userfx.getWeight()));
    this.height.setText(Double.toString(userfx.getHeight()));
    this.calories.setText(Integer.toString(userfx.getCalouries()));
    this.points.setText(Integer.toString(userfx.getPoints()));
    this.avatarImage.setImage(
        new Image(this.getClass().getResource(userfx.getIconURL()).toString()));
     this.age.setText(Integer.toString(userfx.getAge()));

  }

  @FXML
  private void backOnAction() {

    manager.lastpages.pop();
    if (!manager.lastpages.empty()) {
      try {
        manager.stage.setScene(manager.changeScene(manager.lastpages.pop()));
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else menuOnAction();
  }

  @FXML
  private void menuOnAction() {
    try {
      manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
