package pl.mvwojcik.user.Converters;

import pl.mvwojcik.user.model.User;
import pl.mvwojcik.user.modelfx.UserFX;
import pl.mvwojcik.utils.UserToolbarUtils;

import java.time.LocalDate;
import java.time.Period;

public class UserConverter
{


    public static User userFXtoUser(UserFX userFX)
    {
        User user = new User();

        user.setUsername(userFX.getUsername());
        user.setEmail(userFX.getEmail());
        user.setPassword(userFX.getPassword());
        user.setBornDate(UserToolbarUtils.convertToDate(userFX.getBornDate()));
        user.setGender(userFX.getGender());
        user.setHeight(userFX.getHeight());
        user.setWeight(userFX.getWeight());
        user.setCalouries(userFX.getCalouries());
        user.setPoints(userFX.getPoints());
        return user;
    }

    public static UserFX userToUserFX(User user)
    {
        UserFX userFX = new UserFX();
        userFX.usernameProperty().setValue(user.getUsername());
        userFX.emailProperty().setValue(user.getEmail());
        userFX.setPassword(user.getPassword());
        userFX.setBornDate(UserToolbarUtils.convertToLocalDate(user.getBornDate()));
        userFX.setGender(user.getGender());
        userFX.setWeight(user.getWeight());
        userFX.setHeight(user.getHeight());
        userFX.setCalouries(user.getCalouries());
        userFX.setPoints(user.getPoints());
        userFX.setAge(Period.between(UserToolbarUtils.convertToLocalDate(user.getBornDate()), LocalDate.now()).getYears());


        return userFX;
    }
}
