package pl.mvwojcik;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import static pl.mvwojcik.MainController.controller;

public class FXMLManager implements Initializable {

    public static final String OPTIONSSCENEPATH = "/fxml/OptionsScene.fxml";
    public static final String MAINSCENEPATH= "/fxml/MainScene.fxml";

    public Stage stage;


public static FXMLManager manager;

    public FXMLManager(Stage stage)
    {
        this.stage = stage;
    }
    public static void setStage(Stage stage,String path) throws IOException {
        stage.setScene(changeScene(path));
        stage.setTitle("Szamka");
        stage.show();
    }

    public static Scene changeScene(String path) throws IOException {
        Parent parent = fxmlLoader(path).load();
        return new Scene(parent);
    }

    public static FXMLLoader fxmlLoader(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(FXMLManager.class.getClass().getResource(path));
        //tutaj ustawia sie resources bundles loader.setresources
return loader;
    }
    public Stage getStage()
    {
        return this.stage;
    }

    public void initialize(URL location, ResourceBundle resources) {
        manager=this;
    }
}