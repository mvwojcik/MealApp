package pl.mvwojcik.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@DatabaseTable(tableName = "ingerdients")
public class Ingredient {

  @DatabaseField(generatedId = true)
  private int id;

  @DatabaseField private String name;

  @DatabaseField private int kcal;

  @DatabaseField private double proteins;

  @DatabaseField private double carbohydrates;

  @DatabaseField private double fat;

  @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
  private Alergens alergens;

  @DatabaseField private String base;

  @DatabaseField private Double price;

}
