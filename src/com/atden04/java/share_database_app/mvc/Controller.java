package com.atden04.java.share_database_app.mvc;

import com.atden04.java.share_database_app.models.Stock;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Objects;

public class Controller {

    @FXML
    public MenuItem addStockMenu;
    @FXML
    public MenuItem deleteRowMenu;
    @FXML
    public TabPane tabPane;
    @FXML
    public MenuItem outputData;
    Model model;
    Stage stage;

    public Controller() {
        System.out.println("Controller constructed");
    }

    public void initialise(Model model, Stage stage) {
        this.model = model;
        this.stage = stage;
    }

    public void handleAddStock(ActionEvent actionEvent) {
        Stage addRowStage = new Stage();
        addRowStage.initOwner(stage);

        ObservableList<String> options = this.model.getStockNames();
        options.add(0, "Add Stock");
        ComboBox<String> selectionBox = new ComboBox<>(options);
        TextField addName = new TextField();
        addName.setPromptText("Name");
        addName.setVisible(false);
        TextField addDate = new TextField();
        addDate.setPromptText("Date Bought");
        TextField addQuantity = new TextField();
        addQuantity.setPromptText("Quantity");
        TextField addCost = new TextField();
        addCost.setPromptText("Cost");

        final Button addButton = new Button("Add");

        selectionBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String choice = selectionBox.getValue();
                addName.setVisible(Objects.equals(choice, "Add Stock"));
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String newName = addName.getText();
                String choice = selectionBox.getValue();
                String date = addDate.getText();
                String status = "bought";
                float quantity = Float.parseFloat(addQuantity.getText());
                float cost = Float.parseFloat(addCost.getText());

                if (Objects.equals(choice, "Add Stock")) {
                    model.addStock(newName, date, quantity,cost);
                }
                else {
                    model.addPurchase(choice, date, quantity, cost);
                }
                addName.clear();
                addDate.clear();
                addQuantity.clear();
                addCost.clear();
            }
        });

        HBox hBox = new HBox(selectionBox, addName, addDate, addQuantity, addCost, addButton);
        hBox.alignmentProperty().set(Pos.CENTER);
        hBox.setSpacing(10);

        Scene addRowScene = new Scene(hBox, 900, 100);
        addRowStage.setScene(addRowScene);
        addRowStage.show();
    }

    public void handleAddDividend(ActionEvent actionEvent) {
        Stage addRowStage = new Stage();
        addRowStage.initOwner(stage);

        ComboBox<String> selectionBox = new ComboBox<>(this.model.getStockNames());
        TextField addDate = new TextField();
        addDate.setPromptText("Date Bought");
        TextField addQuantity = new TextField();
        addQuantity.setPromptText("Quantity");
        TextField addValue = new TextField();
        addValue.setPromptText("Value");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String choice = selectionBox.getValue();
                String date = addDate.getText();
                float quantity = Float.parseFloat(addQuantity.getText());
                float value = Float.parseFloat(addValue.getText());
                model.addDividend(choice, date, quantity, value);
                addDate.clear();
                addQuantity.clear();
                addValue.clear();
            }
        });

        HBox hBox = new HBox(selectionBox, addDate, addQuantity, addValue, addButton);
        hBox.alignmentProperty().set(Pos.CENTER);
        hBox.setSpacing(10);

        Scene addRowScene = new Scene(hBox, 900, 100);
        addRowStage.setScene(addRowScene);
        addRowStage.show();

    }

    public void handleDeleteRow(ActionEvent actionEvent) {
    }

    public void handleOutputData(ActionEvent actionEvent) {
        System.out.println(this.model.getAllStock());
    }


}
