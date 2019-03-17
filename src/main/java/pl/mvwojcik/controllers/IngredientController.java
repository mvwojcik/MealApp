package pl.mvwojcik.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import pl.mvwojcik.user.model.Ingredient;

import static pl.mvwojcik.utils.ActiveIngredient.getActiveIngredient;
public class IngredientController {

    @FXML
    private Label ingredientLabel;

    @FXML
    private PieChart ingredientChart;

    @FXML
    void initialize()
    {
        this.ingredientLabel.setText(getActiveIngredient().getName());

        initChart(getActiveIngredient());
    }

    private void initChart(Ingredient ingredient)
    {
        ingredientChart.setTitle("Kcal: "+ingredient.getKcal());
        ObservableList<PieChart.Data> skladniki=FXCollections.observableArrayList(
                new PieChart.Data("Węgle",(int)ingredient.getCarbohydrates()),
                new PieChart.Data("Białko",(int)ingredient.getProteins()),
                new PieChart.Data("Tłuszcze",(int)ingredient.getFat()));
        ingredientChart.setData(skladniki);
    }


}
