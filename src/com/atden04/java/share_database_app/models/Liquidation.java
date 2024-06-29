package com.atden04.java.share_database_app.models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class Liquidation {
    private SimpleStringProperty date;
    private SimpleFloatProperty quantity;
    private SimpleFloatProperty value;

    public Liquidation(String date, float quantity, float value){
        this.date = new SimpleStringProperty(date);
        this.quantity = new SimpleFloatProperty(quantity);
        this.value = new SimpleFloatProperty(value);
    }

    @Override
    public String toString(){
        return "Date : "+this.date+", Quantity : "+this.quantity+", Sale : £"+this.value;
    }
}
