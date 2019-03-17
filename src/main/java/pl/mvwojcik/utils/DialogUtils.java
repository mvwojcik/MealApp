package pl.mvwojcik.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogUtils {
  static ResourceBundle bundle = FXMLManager.getResourceBundle();

  public static void errorDialog(String error) {
    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    errorAlert.setTitle(bundle.getString("Error.Title"));
    errorAlert.setHeaderText(bundle.getString("Error.Header"));

    TextArea errormessage = new TextArea(error);
    errorAlert.getDialogPane().setContent(errormessage);
    errorAlert.showAndWait();
  }

  public static String editDialog(String value) {
    TextInputDialog dialog = new TextInputDialog(value);
    dialog.setTitle(bundle.getString("Edit.Title"));
    dialog.setHeaderText(bundle.getString("Edit.Header"));
    dialog.setContentText(bundle.getString("Edit.Content"));
    Optional<String> result = dialog.showAndWait();
    if (result.isPresent()) {
      return result.get();
    }
    return null;
  }
}
