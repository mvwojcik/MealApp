package pl.mvwojcik.user.Converters;

import pl.mvwojcik.user.model.User;
import pl.mvwojcik.user.modelfx.UserFX;

public class UserConverter
{


    public static User userFXtoUser(UserFX userFX)
    {
        User user = new User();

        user.setUsername(userFX.getUsername());

        return user;
    }

    public static UserFX userToUserFX(User user)
    {
        return new UserFX();
    }
}
