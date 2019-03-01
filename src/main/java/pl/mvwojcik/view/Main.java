package pl.mvwojcik.view;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.mvwojcik.utils.FXMLManager;

import static pl.mvwojcik.utils.FXMLManager.manager;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        FXMLManager loader = new FXMLManager(primaryStage);
        manager=loader;
//manager.setStage(primaryStage,"/fxml/MainScene.fxml");
manager.setStage(primaryStage,"/fxml/WelcomePage.fxml");

    }
}
