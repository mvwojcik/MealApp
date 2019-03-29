package pl.mvwojcik.utils;

import pl.mvwojcik.database.dao.IngredientsDao;
import pl.mvwojcik.database.dao.UserSettingsDao;
import pl.mvwojcik.model.Alergens;
import pl.mvwojcik.model.Ingredient;
import pl.mvwojcik.model.UserSettings;

public class FillDB {

  public static void fillSettingsDB() {
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

  public static void fillIngredientsDB() {

    IngredientsDao ingredientsDao = new IngredientsDao();
    ingredientsDao.dropTable();
    ingredientsDao.createTableifNotExsist();
   // AlergensDao alergensDao = new AlergensDao();
 //   alergensDao.dropTable();
  //  alergensDao.createTableifNotExsist();

    Alergens alergen = createAlergensMeat();
  //  alergensDao.create(alergen);

    Ingredient ingredient = new Ingredient();
    ingredient.setProteins(72);
    ingredient.setKcal(320);
    ingredient.setFat(7.6);
    ingredient.setCarbohydrates(4.2);
    ingredient.setName("Kurczak");
    ingredient.setAlergens(alergen);
    ingredient.setBase(FoodCategories.PROTEINS);
    ingredientsDao.create(ingredient);

    ///////////
    Alergens alergen1 = createAlergensMeat();
    Ingredient ingredient1 = new Ingredient();

    //alergensDao.create(alergen1);
    ingredient1.setProteins(82);
    ingredient1.setKcal(390);
    ingredient1.setFat(10.4);
    ingredient1.setCarbohydrates(2.2);
    ingredient1.setName("Łosoś");
    ingredient1.setAlergens(alergen1);
    ingredient1.setBase(FoodCategories.PROTEINS);
    ingredientsDao.create(ingredient1);
    ///////////////////
    Ingredient ingredient2 = new Ingredient();
    Alergens alergen2 = createAlergensMeat();
   // alergensDao.create(alergen2);
    ingredient2.setProteins(62);
    ingredient2.setKcal(490);
    ingredient2.setFat(20.4);
    ingredient2.setCarbohydrates(14.2);
    ingredient2.setName("Tuńczyk");
    ingredient2.setAlergens(alergen2);
    ingredient2.setBase(FoodCategories.PROTEINS);

    ingredientsDao.create(ingredient2);
    ///////////////////
    Ingredient ingredient3 = new Ingredient();
    Alergens alergen3 = createAlergensVeggies();
    //alergensDao.create(alergen3);
    ingredient3.setProteins(44);
    ingredient3.setKcal(300);
    ingredient3.setFat(10.4);
    ingredient3.setCarbohydrates(33.2);
    ingredient3.setName("Fasola");
    ingredient3.setAlergens(alergen3);
    ingredient3.setBase(FoodCategories.PROTEINS);

    ingredientsDao.create(ingredient3);
  }

  private static Alergens createAlergensMeat() {
    Alergens alergens = new Alergens();
    alergens.setGluten(false);
    alergens.setMeat(true);
    alergens.setMilk(false);
    alergens.setSupplements(false);
    alergens.setVeggies(false);
    alergens.setVegan(false);
    return alergens;
  }

  private static Alergens createAlergensVeggies() {
    Alergens alergens = new Alergens();
    alergens.setGluten(true);
    alergens.setMeat(false);
    alergens.setMilk(false);
    alergens.setSupplements(false);
    alergens.setVeggies(true);
    alergens.setVegan(true);
    return alergens;
  }
}
