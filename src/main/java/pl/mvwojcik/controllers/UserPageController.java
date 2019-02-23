package pl.mvwojcik.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
        //tutaj poloczenie z db i ustawienie tych pól
    }
}
