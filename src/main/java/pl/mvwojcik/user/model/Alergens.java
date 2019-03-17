package pl.mvwojcik.user.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "alergens")
public class Alergens {

    @DatabaseField(generatedId = true) private int id;
  @DatabaseField private boolean meat;
  @DatabaseField private boolean veggies;
  @DatabaseField private boolean supplements;
  @DatabaseField private boolean gluten;
  @DatabaseField private boolean milk;
  @DatabaseField private boolean vegan;

    public boolean isMeat() {
        return meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    public boolean isVeggies() {
        return veggies;
    }

    public void setVeggies(boolean veggies) {
        this.veggies = veggies;
    }

    public boolean isSupplements() {
        return supplements;
    }

    public void setSupplements(boolean supplements) {
        this.supplements = supplements;
    }

    public boolean isGluten() {
        return gluten;
    }

    public void setGluten(boolean gluten) {
        this.gluten = gluten;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    @Override
    public String toString() {
        return "Alergens{" +
                "id=" + id +
                ", meat=" + meat +
                ", veggies=" + veggies +
                ", supplements=" + supplements +
                ", gluten=" + gluten +
                ", milk=" + milk +
                ", vegan=" + vegan +
                '}';
    }
}
