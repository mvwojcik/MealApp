package pl.mvwojcik.utils;

import pl.mvwojcik.model.Ingredient;

public class ActiveIngredient {
    public static Ingredient activeIngredient;

    public static Ingredient getActiveIngredient() {
        return activeIngredient;
    }

    public static void setActiveIngredient(Ingredient activeIngredient) {
        ActiveIngredient.activeIngredient = activeIngredient;
    }
}
