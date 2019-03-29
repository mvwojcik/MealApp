package pl.mvwojcik.modelfx;

import javafx.beans.property.*;
import lombok.Data;
import lombok.ToString;
import pl.mvwojcik.model.Alergens;

@Data
@ToString
public class IngredientFX {

  private SimpleStringProperty name = new SimpleStringProperty();
  private SimpleIntegerProperty kcal = new SimpleIntegerProperty();
  private SimpleDoubleProperty proteins = new SimpleDoubleProperty();
  private SimpleDoubleProperty carbohydrates = new SimpleDoubleProperty();
  private SimpleDoubleProperty fat = new SimpleDoubleProperty();
  private ObjectProperty<Alergens> alergens = new SimpleObjectProperty();

}
