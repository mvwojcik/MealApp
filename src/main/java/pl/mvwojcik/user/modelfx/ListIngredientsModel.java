package pl.mvwojcik.user.modelfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.mvwojcik.Converters.IngredientsConverter;
import pl.mvwojcik.database.dao.IngredientsDao;
import pl.mvwojcik.user.model.Ingredient;

import java.util.List;

public class ListIngredientsModel {

    private ObservableList<IngredientFX> ingredientFXObservableList = FXCollections.observableArrayList();


    public void init()
    {
        IngredientsDao dao = new IngredientsDao();
        List<Ingredient> ingredients = dao.querryForAll();
        ingredients.forEach(ingredient -> {
            this.ingredientFXObservableList.add(IngredientsConverter.toIngredientFX(ingredient));
        });
    }

    public ObservableList<IngredientFX> getIngredientFXObservableList() {
        return ingredientFXObservableList;
    }

    public void setIngredientFXObservableList(ObservableList<IngredientFX> ingredientFXObservableList) {
        this.ingredientFXObservableList = ingredientFXObservableList;
    }
}
