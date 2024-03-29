package pl.mvwojcik.modelfx;

import javafx.beans.property.*;
import lombok.ToString;
import pl.mvwojcik.model.Alergens;
@ToString
public class IngredientFX {

  private SimpleStringProperty name = new SimpleStringProperty();
  private SimpleIntegerProperty kcal = new SimpleIntegerProperty();
  private SimpleDoubleProperty proteins = new SimpleDoubleProperty();
  private SimpleDoubleProperty carbohydrates = new SimpleDoubleProperty();
  private SimpleDoubleProperty fat = new SimpleDoubleProperty();
  private ObjectProperty<Alergens> alergens = new SimpleObjectProperty();

  public int getKcal() {
    return kcal.get();
  }

  public SimpleIntegerProperty kcalProperty() {
    return kcal;
  }

  public void setKcal(int kcal) {
    this.kcal.set(kcal);
  }

  public double getProteins() {
    return proteins.get();
  }

  public SimpleDoubleProperty proteinsProperty() {
    return proteins;
  }

  public void setProteins(double proteins) {
    this.proteins.set(proteins);
  }

  public double getCarbohydrates() {
    return carbohydrates.get();
  }

  public SimpleDoubleProperty carbohydratesProperty() {
    return carbohydrates;
  }

  public void setCarbohydrates(double carbohydrates) {
    this.carbohydrates.set(carbohydrates);
  }

  public double getFat() {
    return fat.get();
  }

  public SimpleDoubleProperty fatProperty() {
    return fat;
  }

  public void setFat(double fat) {
    this.fat.set(fat);
  }

  public String getName() {
    return name.get();
  }

  public SimpleStringProperty nameProperty() {
    return name;
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public Alergens getAlergens() {
    return alergens.get();
  }

  public ObjectProperty<Alergens> alergensProperty() {
    return alergens;
  }

  public void setAlergens(Alergens alergens) {
    this.alergens.set(alergens);
  }

}
