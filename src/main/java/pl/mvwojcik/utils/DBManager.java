package pl.mvwojcik.utils;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.mvwojcik.user.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class DBManager {

    private static ConnectionSource connectionSource;


    //private static final String JDBC_DRIVER_HD = "jdbc:postgresql://localhost:5432/Szamka";
    private static final String JDBC_DRIVER_HD = "jdbc:postgresql://localhost:50704/Szamka";
    private static final String USER ="postgres";
    private static final String PASSWORD = "Akademia1";

    public static void createConnectionSource(){
        try {
            connectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD,USER,PASSWORD);
            TableUtils.createTable(connectionSource,User.class);
            System.out.println("done");
        } catch (SQLException e) {
            System.out.println("err here");
            System.out.println(e.getMessage());
        }
    }

    public static void createTable()
    {
        try {
            TableUtils.createTable(connectionSource, User.class);
            //TableUtils.createTableIfNotExists(connectionSource,User.class);
        } catch (SQLException e) {
            System.out.println("err here2");
        }
    }

    public static void insert()
    {

    }



    public static void closeConnectionSource()
    {
        try {
            connectionSource.close();
        } catch (IOException e) {
            System.out.println("err here3");
        }
    }

}
