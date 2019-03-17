package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.mvwojcik.Converters.IngredientsConverter;
import pl.mvwojcik.user.modelfx.IngredientFX;
import pl.mvwojcik.user.modelfx.ListIngredientsModel;
import pl.mvwojcik.utils.FXMLManager;
import pl.mvwojcik.utils.FillDB;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.io.IOException;

import static pl.mvwojcik.utils.FXMLManager.manager;
import static pl.mvwojcik.utils.ActiveIngredient.setActiveIngredient;

public class ProteinsPageController {

  @FXML private BorderPane borderPane;

  @FXML private TableView<IngredientFX> tableView;
  @FXML private TableColumn<IngredientFX, IngredientFX> iconColumn;

  @FXML private TableColumn<IngredientFX, String> nameColumn;

  @FXML private TableColumn<IngredientFX, Number> kcalColumn;

  @FXML private TableColumn<IngredientFX, Number> proteinsColumn;

  @FXML private TableColumn<IngredientFX, Number> carbohydratesCloumn;

  @FXML private TableColumn<IngredientFX, Number> fatColumn;

  @FXML private JFXToggleButton meatToggle;

  @FXML private JFXToggleButton veggiesToggle;

  @FXML private JFXToggleButton supplementsToggle;

  @FXML private JFXToggleButton glutenToggle;

  @FXML private JFXToggleButton milkToggle;

  @FXML private JFXSlider minKcal;

  @FXML private JFXSlider maxKcal;

  private ListIngredientsModel ingredientsList;

  @FXML
  private void initialize() {
    FillDB.fillIngredientsDB();
    this.ingredientsList = new ListIngredientsModel();
    this.ingredientsList.init(); // tu try
    initColumns();

    initTableCell();

    UserToolbarUtils.loadToolbars(this.borderPane);
  }

  private void initTableCell() {
    this.iconColumn.setCellFactory(
        param ->
            new TableCell<IngredientFX, IngredientFX>() {
              JFXButton button = UserToolbarUtils.createButton("/images/man1.jpg");

              @Override
              protected void updateItem(IngredientFX item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                  setGraphic(null);
                  return;
                } else {
                  setGraphic(button);
                  setAlignment(Pos.CENTER);
                  button.setOnAction(
                      event -> {

                        setActiveIngredient(
                            IngredientsConverter.toIngredient(
                                tableView.getItems().get(this.getIndex())));
                        Stage stage = FXMLManager.openIngredientPage();
                        stage.requestFocus();
                      });
                }
              }
            });
  }

  private void initColumns() {
    this.tableView.setItems(this.ingredientsList.getIngredientFXObservableList());

    this.nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
    this.carbohydratesCloumn.setCellValueFactory(param -> param.getValue().carbohydratesProperty());
    this.proteinsColumn.setCellValueFactory(param -> param.getValue().proteinsProperty());
    this.fatColumn.setCellValueFactory(param -> param.getValue().fatProperty());
    this.kcalColumn.setCellValueFactory(param -> param.getValue().kcalProperty());
  }

  @FXML
  void dragKcal() {
    // this.ingredientsList.initByKal((int) this.minKcal.getValue(), (int) this.maxKcal.getValue());
    check();
  }

  public void check() {
    System.out.println("!this.meatToggle.isDisabled() = " + !this.meatToggle.isSelected());
    this.ingredientsList.initList(
        (int) this.minKcal.getValue(),
        (int) this.maxKcal.getValue(),
        this.meatToggle.isSelected(),
        this.veggiesToggle.isSelected(),
        this.supplementsToggle.isSelected(),
        this.glutenToggle.isSelected(),
        this.milkToggle.isSelected());
  }

  @FXML
  void toggle(ActionEvent event) {
    check();
  }

  @FXML
  public void backOnAction(ActionEvent actionEvent) {
    try {
      manager.lastpages.pop();
      manager.stage.setScene(manager.changeScene(manager.lastpages.pop(),true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void menuOnAction(ActionEvent actionEvent) {
    try {
      manager.stage.setScene(manager.changeScene(manager.MAINSCENEPATH,true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
