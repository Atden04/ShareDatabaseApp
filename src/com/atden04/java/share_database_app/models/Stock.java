package com.atden04.java.share_database_app.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static javafx.collections.FXCollections.observableArrayList;

public class Stock {
    private String name;
    private StockStatus status;
    private ObservableList<Purchase> purchases;
    private ObservableList<Dividend> dividends;
    private float totalCost;
    private float totalQuantity;

    public Stock() {
        this.name = "";
        this.status = StockStatus.BOUGHT;
        this.purchases = observableArrayList();
        this.dividends = observableArrayList();
    }

    public Stock(String name, String status) {
        this.name = name;
        if (status.equalsIgnoreCase("bought"))
            this.status = StockStatus.BOUGHT;
        else if (status.equalsIgnoreCase("sold"))
            this.status = StockStatus.SOLD;
        else if (status.equalsIgnoreCase("liquidated"))
            this.status = StockStatus.LIQUIDATED;
        this.purchases = observableArrayList();
        this.dividends = observableArrayList();
    }

    public Stock(String name, String date, float quantity, float cost) {
        this.name = name;
        this.status = StockStatus.BOUGHT;
        this.purchases = observableArrayList();
        this.dividends = observableArrayList();
        this.purchases.add(new Purchase(date, quantity, cost));
        this.totalCost+=cost;
        this.totalQuantity+=quantity;
    }

    public void addPurchase(String date, float quantity, float cost) {
        this.purchases.add(new Purchase(date, quantity, cost));
        if (this.status != StockStatus.BOUGHT)
        {
            this.status = StockStatus.BOUGHT;
        }
        this.totalCost+=cost;
        this.totalQuantity+=quantity;
    }

    public String toString() {
        return "\nStock Name : "+this.getName()+", Status : "+this.getStatus()+", Quantity : "+this.totalQuantity + ", Cost : "+this.totalCost;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
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
