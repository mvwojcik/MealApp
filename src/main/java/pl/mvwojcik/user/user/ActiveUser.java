package pl.mvwojcik.user.user;

import pl.mvwojcik.user.model.User;

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
