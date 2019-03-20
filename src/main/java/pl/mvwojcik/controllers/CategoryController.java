package pl.mvwojcik.controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class CategoryController {
@FXML
  private Button minimalizeIcon;

  @FXML
  private Button fullIViewIcon;

  @FXML
  private Button exitIcon;


  @FXML
  void initialize()
  {
    UserToolbarUtils.loadTopToolbars(minimalizeIcon,fullIViewIcon,exitIcon);

  }
  @FXML
  void breakfastOnAction(ActionEvent event) {
    try {
      manager.stage.setScene(manager.changeScene(manager.PROTEINSPAGESCENEPATH,true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  void dinnerOnAction(ActionEvent event) {}

  @FXML
  void snacksOnAction(ActionEvent event) {}

  @FXML
  void supperOnAction(ActionEvent event) {}

  @FXML
  void returnOnAction(ActionEvent event) {
    try {
      manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH,true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
