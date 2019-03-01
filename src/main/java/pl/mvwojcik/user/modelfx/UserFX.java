package pl.mvwojcik.user.modelfx;

import com.j256.ormlite.table.DatabaseTable;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.Date;


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
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public LocalDate getBornDate() {
        return bornDate.get();
    }

    public ObjectProperty<LocalDate> bornDateProperty() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate.set(bornDate);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public double getWeight() {
        return weight.get();
    }

    public DoubleProperty weightProperty() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    public double getHeight() {
        return height.get();
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public int getCalouries() {
        return calouries.get();
    }

    public IntegerProperty calouriesProperty() {
        return calouries;
    }

    public void setCalouries(int calouries) {
        this.calouries.set(calouries);
    }

    public int getPoints() {
        return points.get();
    }

    public IntegerProperty pointsProperty() {
        return points;
    }

    public void setPoints(int points) {
        this.points.set(points);
    }

    @Override
    public String toString() {
        return "UserFX{" +
                "username=" + username +
                ", password=" + password +
                ", email=" + email +
                ", age=" + age +
                ", bornDate=" + bornDate +
                ", gender=" + gender +
                ", weight=" + weight +
                ", height=" + height +
                ", calouries=" + calouries +
                ", points=" + points +
                '}';
    }
}
