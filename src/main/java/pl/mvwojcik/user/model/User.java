package pl.mvwojcik.user.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pl.mvwojcik.user.user.ActiveUser;
import pl.mvwojcik.utils.OptionsUtils;

import java.util.Date;

@DatabaseTable(tableName = "Userss")
public class User {
    public User() {
        this.userSettingsId= OptionsUtils.defaultUserSettings();
    }


    //@DatabaseField(columnName = "id", generatedId = true/*, unique = true, canBeNull = false*/)
    // private int id;

    @DatabaseField(columnName = "userSettingsId",foreign = true)
    private UserSettings userSettingsId;

    @DatabaseField(columnName = "username", unique = true, canBeNull = false)
    private String username;

    @DatabaseField(columnName = "email", unique = true, canBeNull = false)
    private String email;

    @DatabaseField(columnName = "password", canBeNull = false)
    private String password; //tu trzeba cos madrego wymyślić

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



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  /*  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCalouries() {
        return calouries;
    }

    public void setCalouries(int calouries) {
        this.calouries = calouries;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public UserSettings getUserSettingsId() {
        return userSettingsId;
    }

    public void setUserSettingsId(UserSettings userSettingsId) {
        this.userSettingsId = userSettingsId;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bornDate=" + bornDate +
                ", weight=" + weight +
                ", height=" + height +
                ", calouries=" + calouries +
                ", gender='" + gender + '\'' +
                ", points=" + points +
                '}';
    }
}
