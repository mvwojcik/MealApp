package pl.mvwojcik.utils;

import pl.mvwojcik.database.dao.IngredientsDao;
import pl.mvwojcik.database.dao.UserSettingsDao;
import pl.mvwojcik.user.model.Ingredient;
import pl.mvwojcik.user.model.UserSettings;

public class FillDB {

    public static void fillSettingsDB()
    {
        UserSettings settings1 = new UserSettings();
        settings1.setCurrency(UserSettings.currencies[0]);
        settings1.setLanguage(UserSettings.languages[0]);
        settings1.setTheme(UserSettings.themes[0]);

        UserSettingsDao dao = new UserSettingsDao();

        dao.create(settings1);

        settings1 = new UserSettings();
        settings1.setCurrency(UserSettings.currencies[1]);
        settings1.setCurrency(UserSettings.currencies[1]);
        settings1.setTheme(UserSettings.themes[1]);

        dao.create(settings1);

    }

    public static void fillIngredientsDB()
    {
        Ingredient ingredient = new Ingredient();
        ingredient.setProteins(100.2);
        ingredient.setKcal(204);
        ingredient.setFat(123);
        ingredient.setCarbohydrates(12);
        ingredient.setName("MIENSO");

        IngredientsDao ingredientsDao = new IngredientsDao();
        ingredientsDao.createTableifNotExsist();
        ingredientsDao.create(ingredient);
    }
}
