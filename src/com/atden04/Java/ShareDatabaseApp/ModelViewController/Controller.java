package com.atden04.Java.ShareDatabaseApp.ModelViewController;

import com.atden04.Java.ShareDatabaseApp.DataModel.Person;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {

    @FXML
    public TabPane tabPane;
    @FXML
    public MenuItem addRowMenu;
    @FXML
    public MenuItem deleteRowMenu;

    @FXML Button outputDataButton;
    public VBox menuBox;
    Model model;

    Stage stage;



    public Controller() {
        System.out.println("Controller constructed");
    }

    public void initialise(Model model, Stage stage){
        this.model = model;
        this.stage = stage;
    }

    @FXML
    public void handleAddRow(ActionEvent event) {
        Stage addRowStage = new Stage();
        addRowStage.initOwner(stage);

        TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        TextField addLastName = new TextField();
        addLastName.setPromptText("Last Name");
        TextField addEmail = new TextField();
        addEmail.setPromptText("Email");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                model.getPeople().add(new Person(
                        addFirstName.getText(),
                        addLastName.getText(),
                        addEmail.getText()
                ));
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
            }
        });

        HBox hBox = new HBox(addFirstName, addLastName, addEmail, addButton);
        hBox.alignmentProperty().set(Pos.CENTER);
        hBox.setSpacing(10);

        Scene addRowScene = new Scene(hBox, 600, 100);
        addRowStage.setScene(addRowScene);
        addRowStage.show();



    }

    @FXML
    public void handleDeleteRow(ActionEvent actionEvent) {
    }

    @FXML
    public void handleOutputDataButton(ActionEvent event){
        ObservableList<Person> data = model.getPeople();
        for (Person p:
             data) {
            System.out.println(p);
        }
        System.out.println();
    }

    public void createTable(ObservableList<Person> data){
        TableView table = new TableView();
        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFirstName(t.getNewValue());
                    }
                }
        );


        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setLastName(t.getNewValue());
                    }
                }
        );

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
                    }
                }
        );

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        Tab tableTab = new Tab();
        tableTab.setText("People");
        tableTab.setContent(table);
        tabPane.getTabs().addAll(tableTab);

    }


}
