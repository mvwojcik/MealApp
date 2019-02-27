package pl.mvwojcik.user.model;


import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Userss")
public class User {

    //@DatabaseField(columnName = "id", generatedId = true/*, unique = true, canBeNull = false*/)
    // private int id;

    @DatabaseField(columnName = "username", unique = true, canBeNull = false)
    private String username;

    @DatabaseField(columnName = "email", unique = true, canBeNull = false)
    private String email;

    @DatabaseField(columnName = "password", canBeNull = false)
    private String password; //tu trzeba cos madrego wymyślić

    @DatabaseField(columnName = "born_date", dataType = DataType.DATE_STRING, format = "DD-MM-yyy")
    private Date bornDate;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  /*  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        return "User{" +
              /*  "id=" + id +*/
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bornDate=" + bornDate +
                '}';
    }
}
