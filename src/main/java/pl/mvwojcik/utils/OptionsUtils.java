package pl.mvwojcik.utils;

import pl.mvwojcik.user.model.UserSettings;

import java.util.Locale;

public class OptionsUtils {

  public static UserSettings activeUserSettings = defaultUserSettings();


  private static Locale plLocale = new Locale("pl");
  private static Locale enLocale = new Locale("eng");

  public static UserSettings defaultUserSettings() {
    UserSettings userSettings = new UserSettings();
    userSettings.setCurrency(UserSettings.currencies[0]);
    userSettings.setLanguage(UserSettings.languages[0]);
    userSettings.setTheme(UserSettings.themes[1]);
    return userSettings;
  }
  public static void setLanguage(String language)
  {

    if (language.equals("PL")) {
      Locale.setDefault(plLocale);
    } else {
      Locale.setDefault(enLocale);
    }
  }
}
