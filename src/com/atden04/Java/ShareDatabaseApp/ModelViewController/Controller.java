package com.atden04.Java.ShareDatabaseApp.ModelViewController;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller {

    Model model;

    @FXML
    public TableView tableView;

    @FXML
    public TableColumn firstNameColumn;

    @FXML
    public TableColumn lastNameColumn;

    @FXML
    public TableColumn emailColumn;

    public Controller() {
        System.out.println("Controller constructed");
    }

    public void initialise(Model model){
        this.model = model;
        tableView.setItems(this.model.getPeople());

    }
}
