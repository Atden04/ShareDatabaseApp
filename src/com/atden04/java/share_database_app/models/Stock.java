package com.atden04.java.share_database_app.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static javafx.collections.FXCollections.observableArrayList;

public class Stock {
    private SimpleStringProperty name;
    private StockStatus status;
    private ObservableList<Purchase> purchases;
    private ObservableList<Dividend> dividends;

    public Stock(String name, String status) {
        this.name = new SimpleStringProperty(name);
        if (status.equalsIgnoreCase("bought"))
            this.status = StockStatus.BOUGHT;
        else if (status.equalsIgnoreCase("sold"))
            this.status = StockStatus.SOLD;
        else if (status.equalsIgnoreCase("liquidated"))
            this.status = StockStatus.LIQUIDATED;
        this.purchases = observableArrayList();
        this.dividends = observableArrayList();
    }

    public String toString() {
        return "Stock Name : "+this.getName()+", Status : "+this.getStatus();
    }

    public String getName() {
        return this.name.get();
    }

    public void setName(String newName) {
        this.name.set(newName);
    }

    public StockStatus getStatus() {
        return this.status;
    }

    public void setStatus(StockStatus newStatus) {
        this.status = newStatus;
    }

    public ObservableList<Purchase> getPurchases(){return this.purchases;}

    public ObservableList<Dividend> getDividends(){return this.dividends;}

}
