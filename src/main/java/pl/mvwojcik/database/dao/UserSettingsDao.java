package pl.mvwojcik.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import pl.mvwojcik.database.dbutils.DBManager;
import pl.mvwojcik.user.model.User;
import pl.mvwojcik.user.model.UserSettings;

import java.sql.SQLException;
import java.util.List;

public class UserSettingsDao {
    ConnectionSource connectionSource;

    public UserSettingsDao() {connectionSource = DBManager.getConnectionSource();    }

    public Dao getUserSettingsDao()
    {
        try {
            Dao<UserSettings,Integer> dao = DaoManager.createDao(connectionSource, UserSettings.class);
            return dao;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("err");
        return null;
    }

    public void create(UserSettings userSettings)
    {
        Dao<UserSettings,Integer> dao = this.getUserSettingsDao();
        try {
            dao.create(userSettings);
        } catch (SQLException e) {
        e.printStackTrace();
    }

    }
    public List<UserSettings> querryForAll()
    {
        Dao<UserSettings,Integer> dao = this.getUserSettingsDao();
        try {
            return dao.queryForAll();
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return null; //tu można jakieś exception dać
    }

}
