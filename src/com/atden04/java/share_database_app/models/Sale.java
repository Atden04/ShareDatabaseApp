package com.atden04.java.share_database_app.models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sale {
    private SimpleStringProperty date;
    private SimpleFloatProperty quantity;
    private SimpleFloatProperty value;
    private SimpleFloatProperty profit;

    public Sale(String newDate, float newQuantity, float newValue, float cost){
        this.date = new SimpleStringProperty(newDate);
        this.quantity = new SimpleFloatProperty(newQuantity);
        this.value = new SimpleFloatProperty(newValue);
        this.profit = new SimpleFloatProperty(this.value.get()-cost);
    }

    @Override
    public String toString(){
        return "Date : "+this.date+", Quantity : "+this.quantity+", Sale : £"+this.value+", Profit : £"+this.profit;
    }
}
