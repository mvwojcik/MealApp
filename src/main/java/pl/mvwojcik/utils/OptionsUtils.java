package pl.mvwojcik.utils;

import pl.mvwojcik.user.model.UserSettings;

import java.util.Locale;

public class OptionsUtils {

  public static UserSettings activeUserSettings = defaultUserSettings();

  public static void setInternatiolization() {
    Locale.setDefault(new Locale("pl"));
  }

  public static UserSettings defaultUserSettings() {
    UserSettings userSettings = new UserSettings();
    userSettings.setCurrency(UserSettings.currencies[0]);
    userSettings.setLanguage(UserSettings.languages[0]);
    userSettings.setTheme(UserSettings.themes[1]);
    return userSettings;
  }
}
