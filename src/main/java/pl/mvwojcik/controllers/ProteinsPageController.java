package pl.mvwojcik.controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import pl.mvwojcik.utils.UserToolbarUtils;

public class ProteinsPageController {


    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXListView<String> listView;

    private ObservableList list= FXCollections.observableArrayList("lala","lalala","kakaka");
    static class Cell extends ListCell<String>
    {
        HBox hbox = new HBox();
        JFXComboBox jfxComboBox = new JFXComboBox();

        Label nameOfFood = new Label();
        public Cell()
        {
            super();

            hbox.getChildren().addAll(nameOfFood,jfxComboBox);

        }

        public void updateItem(String name, boolean empty)
        {
            super.updateItem(name,empty);
            setText(null);
            setGraphic(null);

            if (name !=null && !empty)
            {
                nameOfFood.setText(name);
                setGraphic(hbox);
            }
        }

    }
    @FXML
    private void initialize() {
        this.listView.setItems(list);
        listView.setCellFactory(param -> new Cell());
        UserToolbarUtils.loadToolbars(this.borderPane);
    }


}
