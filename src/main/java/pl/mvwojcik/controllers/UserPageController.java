package pl.mvwojcik.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.mvwojcik.user.Converters.UserConverter;
import pl.mvwojcik.user.modelfx.UserFX;
import pl.mvwojcik.user.model.UserSettings.*;
import static pl.mvwojcik.user.user.ActiveUser.user;


public class UserPageController {

    @FXML
    private Label username;

    @FXML
    private Label email;

    @FXML
    private Label age;

    @FXML
    private Label weight;

    @FXML
    private Label height;

    @FXML
    private Label calories;

    @FXML
    private Label points;


    @FXML
    public void initialize()
    {
       UserFX userfx =  UserConverter.userToUserFX(user);
this.username.setText(userfx.getUsername());
this.email.setText(userfx.getEmail());
this.weight.setText(Double.toString(userfx.getWeight()));
this.height.setText(Double.toString(userfx.getHeight()));
this.calories.setText(Integer.toString(userfx.getCalouries()));
this.points.setText(Integer.toString(userfx.getPoints()));
//this.age.setText(userfx.getBornDate().toString());

    }
}
