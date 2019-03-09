package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import pl.mvwojcik.user.modelfx.IngredientFX;
import pl.mvwojcik.user.modelfx.ListIngredientsModel;
import pl.mvwojcik.utils.FillDB;
import pl.mvwojcik.utils.UserToolbarUtils;

import static pl.mvwojcik.user.user.ActiveUser.user;
import static pl.mvwojcik.utils.FXMLManager.manager;


public class ProteinsPageController {


    @FXML
    private BorderPane borderPane;

    @FXML
    private TableView<IngredientFX> tableView;
    @FXML
    private TableColumn<IngredientFX, String> iconColumn;

    @FXML
    private TableColumn<IngredientFX, String> nameColumn;

    @FXML
    private TableColumn<IngredientFX, Number> kcalColumn;

    @FXML
    private TableColumn<IngredientFX, Number> proteinsColumn;

    @FXML
    private TableColumn<IngredientFX, Number> carbohydratesCloumn;

    @FXML
    private TableColumn<IngredientFX, Number> fatColumn;

    private ListIngredientsModel ingredientsList;

    @FXML
    private void initialize() {
        FillDB.fillIngredientsDB();
        this.ingredientsList=new ListIngredientsModel();
        this.ingredientsList.init();//tu try
    this.tableView.setItems(this.ingredientsList.getIngredientFXObservableList());

    this.nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
    this.carbohydratesCloumn.setCellValueFactory(param -> param.getValue().carbohydratesProperty());
    this.proteinsColumn.setCellValueFactory(param -> param.getValue().proteinsProperty());
    this.fatColumn.setCellValueFactory(param -> param.getValue().fatProperty());
    this.kcalColumn.setCellValueFactory(param -> param.getValue().kcalProperty());



        UserToolbarUtils.loadToolbars(this.borderPane);
    }


}
