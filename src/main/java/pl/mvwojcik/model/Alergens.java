package pl.mvwojcik.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@DatabaseTable(tableName = "alergens")

public class Alergens {

    @DatabaseField(generatedId = true) private int id;
  @DatabaseField private boolean meat;
  @DatabaseField private boolean veggies;
  @DatabaseField private boolean supplements;
  @DatabaseField private boolean gluten;
  @DatabaseField private boolean milk;
  @DatabaseField private boolean vegan;

}
