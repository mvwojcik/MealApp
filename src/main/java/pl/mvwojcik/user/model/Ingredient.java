package pl.mvwojcik.user.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ingerdients")
public class Ingredient {

  @DatabaseField(generatedId = true) private  int id;

  @DatabaseField private String name;

  @DatabaseField private int kcal;

  @DatabaseField private double proteins;

  @DatabaseField private double carbohydrates;

  @DatabaseField private double fat;

  @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true) private Alergens alergens;



  //@DatabaseField private

  public int getKcal() {
    return kcal;
  }

  public void setKcal(int kcal) {
    this.kcal = kcal;
  }

  public double getProteins() {
    return proteins;
  }

  public void setProteins(double proteins) {
    this.proteins = proteins;
  }

  public double getCarbohydrates() {
    return carbohydrates;
  }

  public void setCarbohydrates(double carbohydrates) {
    this.carbohydrates = carbohydrates;
  }

  public double getFat() {
    return fat;
  }

  public void setFat(double fat) {
    this.fat = fat;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Alergens getAlergens() {
    return alergens;
  }

  public void setAlergens(Alergens alergens) {
    this.alergens = alergens;
  }

  @Override
  public String toString() {
    return "Ingredient{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", kcal=" + kcal +
            ", proteins=" + proteins +
            ", carbohydrates=" + carbohydrates +
            ", fat=" + fat +
            ", alergens=" + alergens.toString() +
            '}';
  }
}
