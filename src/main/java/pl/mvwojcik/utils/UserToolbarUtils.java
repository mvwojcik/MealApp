package pl.mvwojcik.utils;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
public class UserToolbarUtils {

    public static void loadTopToolbars(Button minimalizeIcon, Button fullViewIcon, Button exitIcon)
    {
        minimalizeIcon.setOnMouseReleased(event -> ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true));
        fullViewIcon.setOnMouseReleased(event -> ((Stage)((Button)event.getSource()).getScene().getWindow()).setMaximized(true));
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
      FontAwesomeIcon icon =FontAwesomeIcon.ARROW_RIGHT;

      FontAwesomeIconView iconView = new FontAwesomeIconView(icon);
      iconView.setGlyphSize(20);
      iconView.setGlyphSize(20);
      button.setGraphic(iconView);
    return button;
  }
}
