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
        IngredientsDao ingredientsDao = new IngredientsDao();
        ingredientsDao.createTableifNotExsist();

        Ingredient ingredient = new Ingredient();
        ingredient.setProteins(72);
        ingredient.setKcal(320);
        ingredient.setFat(7.6);
        ingredient.setCarbohydrates(4.2);
        ingredient.setName("Kurczak");

        ingredientsDao.create(ingredient);

        ingredient.setProteins(82);
        ingredient.setKcal(390);
        ingredient.setFat(10.4);
        ingredient.setCarbohydrates(2.2);
        ingredient.setName("Łosoś");

        ingredientsDao.create(ingredient);

        ingredient.setProteins(62);
        ingredient.setKcal(490);
        ingredient.setFat(20.4);
        ingredient.setCarbohydrates(14.2);
        ingredient.setName("Tuńczyk");

        ingredientsDao.create(ingredient);



    }
}
