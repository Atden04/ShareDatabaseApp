package com.atden04.java.share_database_app.mvc;

import com.atden04.java.share_database_app.models.Stock;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public class Model {
    Controller controller;
    private ObservableList<Stock> stock;
    private ObservableList<String> stockNames;

    public void initialise(Controller controller) {
        this.controller = controller;
        this.createStock();
        //this.controller.createTable(this.stock, this.selectedStock);
    }

    private void createStock() {
        this.stock = FXCollections.observableArrayList(
                new Stock("StockA", "08/12/2023", 5, 10)
        );
        this.stockNames = FXCollections.observableArrayList("StockA");
    }

    private Stock getStock(String name) {
        Stock returnValue = null;
        for (Stock s: this.stock) {
            if (Objects.equals(name, s.getName()))
                returnValue = s;
        }
        return returnValue;
    }

    public ObservableList<Stock> getAllStock(){
        return this.stock;
    }

    public ObservableList<String> getStockNames() {
        return this.stockNames;
    }

    public void addStock(String newName, String date, float quantity, float cost)
    {
        this.stock.add(new Stock(newName, date, quantity, cost));
        this.stockNames.add(newName);
    }

    public void addPurchase(String name, String date, float quantity, float cost)
    {
        Stock stock = this.getStock(name);
        stock.addPurchase(date, quantity, cost);
    }

    public void addDividend(String choice, String date, float quantity, float value) {
        this.getStock(choice).addDividend(date, quantity, value);
    }
}
