package pl.mvwojcik.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DatabaseTable
public class UserSettings {

  UserSettings userSettings;

  public static final String[] languages = {"PL", "ENG"};
  public static final String[] currencies = {
    "PLN", "EURO", "FUNT", "DOLAR"
  }; // tutaj trzeba dodać jakoś zamiast tego resources bundles chociaz w sumie chyba nie bo to tylko db
  public static final String[] themes = {"Light", "Dark"};

  @DatabaseField(generatedId = true)
  private int id;

  @DatabaseField private String language;

  @DatabaseField private String currency;

  @DatabaseField private String theme;

}
