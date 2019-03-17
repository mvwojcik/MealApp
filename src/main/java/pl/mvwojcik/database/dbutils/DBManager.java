package pl.mvwojcik.database.dbutils;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.mvwojcik.user.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class DBManager {

  private static ConnectionSource connectionSource;

  private static final String JDBC_DRIVER_HD = "jdbc:postgresql://localhost:5432/Szamka";
  private static final String USER = "postgres";
  private static final String PASSWORD = "haslo1";

  public static void createConnectionSource() {
    try {
      connectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD, USER, PASSWORD);
      System.out.println("done");
    } catch (SQLException e) {
      System.out.println("err here");
      System.out.println(e.getMessage());
    }
  }

  public  static void createTable() {
    try {
      TableUtils.createTableIfNotExists(connectionSource, User.class);
    } catch (SQLException e) {
      System.out.println("err here2");
      System.out.println(e.getMessage());
    }
  }

  public static void dropTable() {
    try {
      TableUtils.dropTable(connectionSource, User.class, true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void closeConnectionSource() {
    try {
      connectionSource.close();
    } catch (IOException e) {
      System.out.println("err here3");
    }
  }

  public static ConnectionSource getConnectionSource() {
    return connectionSource;
  }
}
