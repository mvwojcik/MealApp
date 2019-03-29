package pl.mvwojcik.model;

public class ActiveUser {
  public static User user;

  public ActiveUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
