package pl.mvwojcik.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.mvwojcik.database.dbutils.DBManager;
import pl.mvwojcik.model.Alergens;

import java.sql.SQLException;

public class AlergensDao {
    ConnectionSource connectionSource;

    public AlergensDao() {

        connectionSource = DBManager.getConnectionSource();
    }

    public void createTableifNotExsist() {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Alergens.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dropTable()
    {
        try {
            TableUtils.dropTable(connectionSource,Alergens.class,true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Dao getAlergensDao() {
        try {
            Dao<Alergens, Integer> dao = DaoManager.createDao(connectionSource, Alergens.class);
            return dao;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("err");
        return null;
    }
    public void create(Alergens alergens) {
        Dao<Alergens, Integer> dao = this.getAlergensDao();
        try {
            dao.create(alergens);
    } catch (SQLException e) {
      e.printStackTrace();
        }
    }
}
