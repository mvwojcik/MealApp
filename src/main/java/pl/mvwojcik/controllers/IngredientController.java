package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXScrollPane;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pl.mvwojcik.user.model.Ingredient;

import static pl.mvwojcik.utils.ActiveIngredient.getActiveIngredient;

public class IngredientController {

  @FXML private Label ingredientLabel;

  @FXML private PieChart ingredientChart;
  @FXML private JFXScrollPane scroll;
  @FXML private HBox vbox;
  ListView listView;
  ListView listView2;

  @FXML
  void initialize() {
    this.ingredientLabel.setText(getActiveIngredient().getName());
    listView = new ListView();
    listView2 = new ListView();
    FontAwesomeIcon[] fontAwesomeIcons = FontAwesomeIcon.values();
    ObservableList<Text> text = FXCollections.observableArrayList();
    ObservableList<String> text1 = FXCollections.observableArrayList();
    for (int i = 0; i < fontAwesomeIcons.length; i++) {
      text.add(GlyphsDude.createIcon(fontAwesomeIcons[i]));
      text1.add(fontAwesomeIcons[i].name());
    }
    listView.setItems(text);
    listView2.setItems(text);
    scroll.getChildren().add(listView);
    scroll.getChildren().add(listView2);
    initChart(getActiveIngredient());
  }

  private void initChart(Ingredient ingredient) {
    ingredientChart.setTitle("Kcal: " + ingredient.getKcal());
    ObservableList<PieChart.Data> skladniki =
        FXCollections.observableArrayList(
            new PieChart.Data("Węgle", (int) ingredient.getCarbohydrates()),
            new PieChart.Data("Białko", (int) ingredient.getProteins()),
            new PieChart.Data("Tłuszcze", (int) ingredient.getFat()));
    ingredientChart.setData(skladniki);
  }
}
