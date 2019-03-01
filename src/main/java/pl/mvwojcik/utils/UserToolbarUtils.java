package pl.mvwojcik.utils;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
           AnchorPane toolbar = FXMLLoader.load(UserFX.class.getClass().getResource("/fxml/UserPanel.fxml"));
            drawer.setSidePane(toolbar);
           // drawer.setDefaultDrawerSize(100);
            toolbar.autosize();

        } catch (IOException e) {
            e.printStackTrace();
        }
        final HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {

            task.setRate(task.getRate() * -1);
            task.play();
            if (drawer.isClosed()) {
                drawer.open();

            } else {
                drawer.close();
            }
        });

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
