package pl.mvwojcik.utils;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pl.mvwojcik.user.modelfx.UserFX;


import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class UserToolbarUtils {

    public static void initDrawer(JFXDrawer drawer, JFXHamburger hamburger)
    {


        try {
           VBox toolbar = FXMLLoader.load(UserFX.class.getClass().getResource("/fxml/UserPanel.fxml"));
            drawer.setSidePane(toolbar);
           // drawer.setDefaultDrawerSize(100);
            //toolbar.autosize();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
            drawer.toggle();
        });
        drawer.setOnDrawerOpening((event) -> {
            task.setRate(task.getRate() * -1);
            task.play();
            drawer.toFront();
        });
        drawer.setOnDrawerClosed((event) -> {
            drawer.toBack();
            task.setRate(task.getRate() * -1);
            task.play();
        });


    }

    public static void loadToolbars(BorderPane pane)
    {
        try {
            System.out.println("LALA");
            VBox vBox = FXMLLoader.load(UserToolbarUtils.class.getClass().getResource("/fxml/UserPanel.fxml"));
            System.out.println("XA");
pane.setLeft(vBox);
System.out.println("LALALALA");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Date convertToDate(LocalDate localDate)
    {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate convertToLocalDate(Date date)
    {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }


}
