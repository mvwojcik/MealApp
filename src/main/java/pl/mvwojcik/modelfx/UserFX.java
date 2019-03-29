package pl.mvwojcik.modelfx;

import com.j256.ormlite.table.DatabaseTable;
import javafx.beans.property.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class UserFX {

  private StringProperty username;

  private StringProperty password;

  private StringProperty email;

  private IntegerProperty age;

  private ObjectProperty<LocalDate> bornDate = new SimpleObjectProperty<>();

  private StringProperty gender;

  private DoubleProperty weight;

  private DoubleProperty height;

  private IntegerProperty calouries;

  private IntegerProperty points;

  private StringProperty iconURL;

  public UserFX() {
    this.username = new SimpleStringProperty("");
    this.password = new SimpleStringProperty("");
    this.email = new SimpleStringProperty("");
    this.age = new SimpleIntegerProperty(0);
    this.gender = new SimpleStringProperty("");
    this.weight = new SimpleDoubleProperty(0.0);
    this.height = new SimpleDoubleProperty(0.0);
    this.calouries = new SimpleIntegerProperty(0);
    this.points = new SimpleIntegerProperty(0);
    this.iconURL = new SimpleStringProperty("");
  }
}
