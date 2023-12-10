package com.atden04.java.share_database_app.models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Dividend {
    private SimpleStringProperty date;
    private SimpleFloatProperty quantity;

    private SimpleFloatProperty paymentRate;
    private SimpleFloatProperty value;

    /**
     * blah blah
     * @param newDate Date Dividend occurred
     * @param newQuantity quantity
     * @param newCost cost of share.
     */
    public Dividend(String newDate, float newQuantity, float newCost){
        this.date = new SimpleStringProperty(newDate);
        this.quantity = new SimpleFloatProperty(newQuantity);
        this.value = new SimpleFloatProperty(newCost);
        this.paymentRate = new SimpleFloatProperty(this.value.get()/this.quantity.get());
    }

    @Override
    public String toString(){
        return "Date : "+this.date+", Quantity : "+this.quantity+", Payment Rate : £"+this.paymentRate+", Value : £"+this.value;
    }
}
