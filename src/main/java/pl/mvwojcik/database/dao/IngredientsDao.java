package pl.mvwojcik.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.mvwojcik.database.dbutils.DBManager;
import pl.mvwojcik.user.model.Ingredient;
import pl.mvwojcik.user.model.User;

import java.sql.SQLException;
import java.util.List;

public class IngredientsDao {
    ConnectionSource connectionSource;
    public IngredientsDao()
    {

            connectionSource = DBManager.getConnectionSource();
    }

    public void createTableifNotExsist()
    {
        try {
            TableUtils.createTableIfNotExists(connectionSource,Ingredient.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public Dao getIngredientsDao()
        {
            try {
                Dao<Ingredient,Integer> dao = DaoManager.createDao(connectionSource, Ingredient.class);
                return dao;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("err");
            return null;
        }
    public void create(Ingredient ingredient)
    {
        Dao<Ingredient,Integer> dao = this.getIngredientsDao();
        try {
            dao.create(ingredient);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Ingredient> querryForAll()
    {
        Dao<Ingredient,Integer> dao = this.getIngredientsDao();
        try {
            return dao.queryForAll();
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return null; //tu można jakieś exception dać
    }



}
