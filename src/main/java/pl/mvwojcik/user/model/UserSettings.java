package pl.mvwojcik.user.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class UserSettings {

    UserSettings userSettings;

    public static final String [] languages = {"PL","ENG"};
    public static final String [] currencies = {"PLN","EURO","FUNT","DOLAR"};//tutaj trzeba dodać jakoś zamiast tego resources bundles
    public static final String [] themes = {"Light","Dark"};
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String language;

    @DatabaseField
    private String currency;

    @DatabaseField
    private String theme;

    public UserSettings() {
    }

    public UserSettings(UserSettings userSettings) {
    this.userSettings=userSettings;
    }

    public UserSettings getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(UserSettings userSettings) {
        this.userSettings = userSettings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
