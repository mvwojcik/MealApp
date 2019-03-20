package pl.mvwojcik.utils;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.mvwojcik.user.modelfx.IngredientFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class FXMLManager implements Initializable {

  public static final String OPTIONSSCENEPATH = "/fxml/OptionsScene.fxml";
  public static final String MAINSCENEPATH = "/fxml/MainScene.fxml";
  public static final String LOGINSCENEPATH = "/fxml/loginScene.fxml";
  public static final String REGISTERSCENEPATH = "/fxml/registerScene.fxml";
  public static final String EXPLORESCENEPATH = "/fxml/ExploreCategory.fxml";
  public static final String EXPLOREPAGESCENEPATH = "/fxml/ExplorePage.fxml";
  public static final String USERPAGESCENEPATH = "/fxml/UserPage.fxml";
  public static final String WELCOMEPAGESCENEPATH = "/fxml/WelcomePage.fxml";
  public static final String PROTEINSPAGESCENEPATH = "/fxml/proteinsPage.fxml";


  public static double x =0;
  public static double y =0;
  public Stage stage;

  public static Stack<String> lastpages;

  public static FXMLManager manager;

  public FXMLManager(Stage stage) {
    lastpages = new Stack<>();
    this.stage = stage;
  }

  public static void setStage(Stage stage, String path,boolean stack) throws IOException {
    stage.setScene(changeScene(path,stack));
    stage.setTitle("Szamka");
    stage.show();
  }

  public static Scene changeScene(String path,boolean stack) throws IOException {
    if (stack){
    if (path.equals(MAINSCENEPATH)) {
      lastpages = new Stack<>();
    } else if (!path.equals(WELCOMEPAGESCENEPATH)) {
      lastpages.push(path);
    }}
    Parent parent = fxmlLoader(path).load();
    movingStage(parent);

    return new Scene(parent);
  }

  private static void movingStage(Parent parent) {
    parent.setOnMousePressed(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
      }
    });
    parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
            manager.stage.setX(event.getScreenX() - x);
            manager.stage.setY(event.getScreenY() - y);
          }
        });
  }

  public static FXMLLoader fxmlLoader(String path) throws IOException {
    FXMLLoader loader = new FXMLLoader(FXMLManager.class.getClass().getResource(path));
    loader.setResources(ResourceBundle.getBundle("bundles.msgs"));
    // tutaj ustawia sie resources bundles loader.setresources
    return loader;
  }

  public static Stage openIngredientPage() {
    Stage stage = new Stage();
    stage.setOpacity(0.95);
    try {
      setStage(stage, "/fxml/IngredientContent.fxml",false);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return stage;
  }

  public Stage getStage() {
    return this.stage;
  }

  public static ResourceBundle getResourceBundle() {
    return ResourceBundle.getBundle("bundles.msgs");
  }

  public void initialize(URL location, ResourceBundle resources) {
    manager = this;
  }
}
