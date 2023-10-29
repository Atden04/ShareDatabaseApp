package com.atden04.java.share_database_app.models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Purchase {
    private SimpleStringProperty date;
    private SimpleIntegerProperty quantity;
    private SimpleFloatProperty cost;
    private SimpleFloatProperty costPerShare;

    public Purchase(String newDate, int newQuantity, float newCost){
        this.date = new SimpleStringProperty(newDate);
        this.quantity = new SimpleIntegerProperty(newQuantity);
        this.cost = new SimpleFloatProperty(newCost);
        this.costPerShare = new SimpleFloatProperty(this.cost.get()/this.quantity.get());
    }

    @Override
    public String toString(){
        return "Date : "+this.date+", Quantity : "+this.quantity+", Cost : £"+this.cost+", Cost per Share : £"+this.costPerShare;
    }
}
