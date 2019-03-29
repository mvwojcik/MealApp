package pl.mvwojcik.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import pl.mvwojcik.utils.FXMLManager;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class MainController {
  @FXML private BorderPane borderpane;

  @FXML
  private Button minimalizeIcon;

  @FXML
  private Button fullIViewIcon;

  @FXML
  private Button exitIcon;

  public FXMLManager fxmlManager;

  @FXML
  public void initialize() {

    UserToolbarUtils.loadTopToolbars(minimalizeIcon,fullIViewIcon,exitIcon);
    this.fxmlManager = manager;
    UserToolbarUtils.loadToolbars(borderpane);
  }

  @FXML
  void exploreOnAction() {
    try {
      manager.stage.setScene(manager.changeScene(manager.EXPLORESCENEPATH, true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void optionsOnClick(ActionEvent event) {

    try {
      manager.stage.setScene(manager.changeScene(manager.OPTIONSSCENEPATH, true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  void exitOnClick(ActionEvent event) {
    manager.getStage().close();
    // tutaj okienko dialogowe
  }
}
