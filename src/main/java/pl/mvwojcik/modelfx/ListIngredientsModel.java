package pl.mvwojcik.modelfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.mvwojcik.converters.IngredientsConverter;
import pl.mvwojcik.database.dao.IngredientsDao;
import pl.mvwojcik.model.Ingredient;

import java.util.List;

public class ListIngredientsModel {

  private ObservableList<IngredientFX> ingredientFXObservableList =
      FXCollections.observableArrayList();

  public void init() {
    IngredientsDao dao = new IngredientsDao();
    List<Ingredient> ingredients = dao.querryForAll();
    ingredients.forEach(
        ingredient -> {
          System.out.println(ingredient.toString());
          this.ingredientFXObservableList.add(IngredientsConverter.toIngredientFX(ingredient));
        });
  }

  public List<Ingredient> prepareByKal(int minKcal, int maxKcal) {
    IngredientsDao dao = new IngredientsDao();
    // clearList();
    return dao.queryForKcal(minKcal, maxKcal);
  }

  public void initList(
      int minKcal,
      int maxKcal,
      boolean meat,
      boolean veggies,
      boolean supplements,
      boolean gluten,
      boolean milk) {
    clearList();
    List<Ingredient> ingredients =
        preparebyRequirements(minKcal, maxKcal, meat, veggies, supplements, gluten, milk);
    ingredients.forEach(
        ingredient ->
            this.ingredientFXObservableList.add(IngredientsConverter.toIngredientFX(ingredient)));
  }

  public List<Ingredient> preparebyRequirements(
      int minKcal,
      int maxKcal,
      boolean meat,
      boolean veggies,
      boolean supplements,
      boolean gluten,
      boolean milk) {
    List<Ingredient> ingredients = prepareByKal(minKcal, maxKcal);
    ingredients.removeIf(ingredient -> !meat && ingredient.getAlergens().isMeat());
    ingredients.removeIf(ingredient -> !veggies && ingredient.getAlergens().isVeggies());
    ingredients.removeIf(ingredient -> !supplements && ingredient.getAlergens().isSupplements());
    ingredients.removeIf(ingredient -> !gluten && ingredient.getAlergens().isGluten());
    ingredients.removeIf(ingredient -> !milk && ingredient.getAlergens().isMilk());
    return ingredients;
  }

  public void clearList() {
    this.ingredientFXObservableList.clear();
  }

  public ObservableList<IngredientFX> getIngredientFXObservableList() {
    return ingredientFXObservableList;
  }

  public void setIngredientFXObservableList(
      ObservableList<IngredientFX> ingredientFXObservableList) {
    this.ingredientFXObservableList = ingredientFXObservableList;
  }
}
