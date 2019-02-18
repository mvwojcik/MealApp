package pl.mvwojcik;

import javafx.application.Application;
import javafx.stage.Stage;

import static pl.mvwojcik.FXMLManager.manager;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        FXMLManager loader = new FXMLManager(primaryStage);
        manager=loader;
manager.setStage(primaryStage,"/fxml/MainScene.fxml");


    }
}
