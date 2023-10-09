package com.atden04.java.share_database_app.models;

import javafx.beans.property.SimpleStringProperty;

public class Stock {
    private final SimpleStringProperty name;
    private final SimpleStringProperty dateOfPurchase;
    private StockStatus status;

    public Stock(String name, String dateOfPurchase, String status) {
        this.name = new SimpleStringProperty(name);
        this.dateOfPurchase = new SimpleStringProperty(dateOfPurchase);
        if (status.equalsIgnoreCase("bought"))
            this.status = StockStatus.BOUGHT;
        else if (status.equalsIgnoreCase("sold"))
            this.status = StockStatus.SOLD;
        else if (status.equalsIgnoreCase("liquidated"))
            this.status = StockStatus.LIQUIDATED;
    }

    public String toString() {
        return "Stock Name : "+this.getName()+", Date of Purchase : "+this.getDateOfPurchase()+", Status : "+this.getStatus();
    }

    public String getName() {
        return this.name.get();
    }

    public void setName(String newName) {
        this.name.set(newName);
    }

    public String getDateOfPurchase() {
        return this.dateOfPurchase.get();
    }

    public void setDateOfPurchase(String newDate) {
        this.dateOfPurchase.set(newDate);
    }

    public StockStatus getStatus() {
        return this.status;
    }

    public void setStatus(StockStatus newStatus) {
        this.status = newStatus;
    }

}
