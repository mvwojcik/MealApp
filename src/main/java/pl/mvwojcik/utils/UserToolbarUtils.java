package pl.mvwojcik.utils;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.text.IconView;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static pl.mvwojcik.utils.FXMLManager.manager;
public class UserToolbarUtils {

    public static void loadTopToolbars(Button minimalizeIcon, Button fullViewIcon, Button exitIcon)
    {
        minimalizeIcon.setOnMouseReleased(event -> manager.stage.setIconified(true));
        fullViewIcon.setOnMouseReleased(event -> manager.stage.setMaximized(true));
        exitIcon.setOnMouseReleased(event -> ((Stage)((Button)event.getSource()).getScene().getWindow()).close());
    }

    public static void loadToolbars(BorderPane pane) {
    try {
      VBox vBox =
          FXMLLoader.load(UserToolbarUtils.class.getClass().getResource("/fxml/UserPanel.fxml"));
      pane.setLeft(vBox);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static Date convertToDate(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
  }

  public static LocalDate convertToLocalDate(Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }

  public static JFXButton createButton(String string) {
    JFXButton button = new JFXButton();
    Image image = new Image(UserToolbarUtils.class.getClass().getResource(string).toString());
    ImageView imageView = new ImageView(image);
    imageView.setFitHeight(20);
    imageView.setFitWidth(20);
    button.setGraphic(imageView);
    return button;
  }
}
