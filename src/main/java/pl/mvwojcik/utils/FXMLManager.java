package pl.mvwojcik.utils;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLManager implements Initializable {

    public static final String OPTIONSSCENEPATH = "/fxml/OptionsScene.fxml";
    public static final String MAINSCENEPATH= "/fxml/MainScene.fxml";
    public static final String LOGINSCENEPATH= "/fxml/loginScene.fxml";
    public static final String REGISTERSCENEPATH= "/fxml/registerScene.fxml";
    public static final String EXPLORESCENEPATH= "/fxml/ExploreCategory.fxml";
    public static final String EXPLOREPAGESCENEPATH= "/fxml/ExplorePage.fxml";
    public static final String USERPAGESCENEPATH= "/fxml/UserPage.fxml";
    public static final String WELCOMEPAGESCENEPATH= "/fxml/WelcomePage.fxml";
    public static final String PROTEINSPAGESCENEPATH= "/fxml/proteinsPage.fxml";

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
        loader.setResources(ResourceBundle.getBundle("bundles.msgs"));
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
