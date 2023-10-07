package com.atden04.Java.ShareDatabaseApp.ModelViewController;

import com.atden04.Java.ShareDatabaseApp.DataModel.Person;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    public TabPane tabPane;
    Model model;



    public Controller() {
        System.out.println("Controller constructed");
    }

    public void initialise(Model model){
        this.model = model;

    }

    public void createTable(ObservableList<Person> data){
        TableView table = new TableView();
        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email"));

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        Tab tableTab = new Tab();
        tableTab.setText("People");
        tableTab.setContent(table);
        tabPane.getTabs().addAll(tableTab);

    }
}
