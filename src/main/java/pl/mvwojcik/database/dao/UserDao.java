package pl.mvwojcik.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import pl.mvwojcik.database.dbutils.DBManager;
import pl.mvwojcik.user.model.User;

import java.sql.SQLException;
import java.util.List;


public class UserDao {

    ConnectionSource connectionSource;
    public UserDao()
    {
        connectionSource = DBManager.getConnectionSource();
    }
public Dao getUserDao()
{
    try {
        Dao<User,Integer> dao = DaoManager.createDao(connectionSource, User.class);
        return dao;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    System.out.println("err");
    return null;
}

public void create(User user)
{
    Dao<User,Integer> dao = this.getUserDao();
    try {
        dao.create(user);
    } catch (SQLException e) {
        e.printStackTrace();
    }

}

public void delete()
{

}

public User findByUsername(String temp)
{
    Dao<User,Integer> dao = this.getUserDao();
    QueryBuilder queryBuilder = dao.queryBuilder();
    try {
      queryBuilder.where().eq("username",temp);
      PreparedQuery<User> prepare = queryBuilder.prepare();
      List <User> users = dao.query(prepare);
        return users.get(0);
    } catch (SQLException e) {
        e.printStackTrace();
    }
return null;
}

public List<User> querryForAll()
{
    Dao<User,Integer> dao = this.getUserDao();
    try {
        return dao.queryForAll();
    } catch (SQLException e) {

        e.printStackTrace();

    }
    return null; //tu można jakieś exception dać
}



}
