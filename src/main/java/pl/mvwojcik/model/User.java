package pl.mvwojcik.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Data;
import lombok.ToString;
import pl.mvwojcik.utils.OptionsUtils;

import java.util.Date;


@Data
@ToString
@DatabaseTable(tableName = "Userss")
public class User {
  public User() {
    this.userSettingsId = OptionsUtils.defaultUserSettings();
  }

  // @DatabaseField(columnName = "id", generatedId = true/*, unique = true, canBeNull = false*/)
  // private int id;


  @DatabaseField(columnName = "username", unique = true, canBeNull = false)
  private String username;

  @DatabaseField(columnName = "email", unique = true, canBeNull = false)
  private String email;

  @DatabaseField(columnName = "password", canBeNull = false)
  private String password; // tu trzeba cos madrego wymyślić

  @DatabaseField(columnName = "born_date")
  private Date bornDate;

  @DatabaseField(columnName = "weight")
  private double weight;

  @DatabaseField(columnName = "height")
  private double height;

  @DatabaseField(columnName = "calouries")
  private int calouries;

  @DatabaseField(columnName = "gender")
  private String gender;

  @DatabaseField(columnName = "points")
  private int points;

  @DatabaseField(columnName = "imageurl")
  private String imageurl;

  @DatabaseField(columnName = "userSettingsId", foreign = true)
  private UserSettings userSettingsId;
}
