package pl.mvwojcik.Converters;

import pl.mvwojcik.user.model.Ingredient;
import pl.mvwojcik.user.modelfx.IngredientFX;

public class IngredientsConverter {

  public static IngredientFX toIngredientFX(Ingredient ingredient) {
    IngredientFX ingredientFX = new IngredientFX();
    ingredientFX.setKcal(ingredient.getKcal());
    ingredientFX.setFat(ingredient.getFat());
    ingredientFX.setCarbohydrates(ingredient.getCarbohydrates());
    ingredientFX.setProteins(ingredient.getProteins());
    ingredientFX.setName(ingredient.getName());
    ingredientFX.setAlergens(ingredient.getAlergens());
    return ingredientFX;
  }

  public static Ingredient toIngredient(IngredientFX ingredientFX) {
    Ingredient ingredient = new Ingredient();
    ingredient.setCarbohydrates(ingredientFX.getCarbohydrates());
    ingredient.setFat(ingredientFX.getFat());
    ingredient.setKcal(ingredientFX.getKcal());
    ingredient.setProteins(ingredientFX.getProteins());
    ingredient.setName(ingredientFX.getName());
    ingredient.setAlergens(ingredientFX.getAlergens());
    return ingredient;
  }
}
