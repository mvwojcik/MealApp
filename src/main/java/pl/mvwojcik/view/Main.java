package pl.mvwojcik.view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.mvwojcik.utils.FXMLManager;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class Main extends Application {
  public void start(Stage primaryStage) throws Exception {
    FXMLManager loader = new FXMLManager(primaryStage);
    manager = loader;
    primaryStage.initStyle(StageStyle.UNDECORATED);
    manager.setStage(primaryStage, "/fxml/WelcomePage.fxml",true);

  }
}
