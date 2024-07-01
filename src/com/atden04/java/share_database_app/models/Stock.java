package com.atden04.java.share_database_app.models;

import com.atden04.java.share_database_app.enums.StockStatus;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import static javafx.collections.FXCollections.observableArrayList;

public class Stock {
    private SimpleStringProperty name;
    private StockStatus status;
    private ObservableList<Purchase> purchases;
    private ObservableList<Dividend> dividends;
    private ObservableList<Sale> sales;
    private ObservableList<Liquidation> liquidations;
    private float totalCost;
    private float totalQuantity;
    private float totalReturn;

    public Stock() {
        this.name = new SimpleStringProperty();
        this.status = StockStatus.BOUGHT;
        this.purchases = observableArrayList();
        this.dividends = observableArrayList();
        this.sales = observableArrayList();
        this.liquidations = observableArrayList();
    }

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
        this.sales = observableArrayList();
        this.liquidations = observableArrayList();
    }

    public Stock(String name, String date, float quantity, float cost) {
        this.name = new SimpleStringProperty(name);
        this.status = StockStatus.BOUGHT;
        this.purchases = observableArrayList();
        this.dividends = observableArrayList();
        this.purchases.add(new Purchase(date, quantity, cost));
        this.sales = observableArrayList();
        this.liquidations = observableArrayList();
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

    public void addDividend(String date, float quantity, float value) {
        this.dividends.add(new Dividend(date, quantity, value));
        this.totalReturn+=value;
    }

    public void addSale(String date, float value) {
        this.sales.add(new Sale(date, this.totalQuantity, value, this.totalCost));
        this.status = StockStatus.SOLD;
        this.totalReturn = value-this.totalCost;
        this.totalQuantity = 0;
        this.totalCost = 0;
    }

    public void addLiquidation(String date, float value) {
        this.liquidations.add(new Liquidation(date, this.totalQuantity, value));
        this.status = StockStatus.LIQUIDATED;
        this.totalReturn+=value;
        this.totalQuantity = 0;
    }

    public String toString() {
        return "\nStock Name : "+this.getName()+", Status : "+this.getStatus()+", Quantity : "+this.totalQuantity + ", Cost : "+this.totalCost+", Return : "+this.totalReturn;
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
