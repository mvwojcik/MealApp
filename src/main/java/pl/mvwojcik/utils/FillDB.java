package pl.mvwojcik.utils;

import pl.mvwojcik.database.dao.UserSettingsDao;
import pl.mvwojcik.user.model.UserSettings;

public class FillDB {

    public static void fillSettingsDB()
    {
        UserSettings settings1 = new UserSettings();
        settings1.setCurrency(UserSettings.currencies[0]);
        settings1.setLanguage(UserSettings.languages[0]);
        settings1.setTheme(UserSettings.themes[0]);

        UserSettingsDao dao = new UserSettingsDao();

        dao.create(settings1);

        settings1 = new UserSettings();
        settings1.setCurrency(UserSettings.currencies[1]);
        settings1.setCurrency(UserSettings.currencies[1]);
        settings1.setTheme(UserSettings.themes[1]);

        dao.create(settings1);

    }
}
