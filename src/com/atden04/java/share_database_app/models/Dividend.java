package com.atden04.java.share_database_app.models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Class to store all data regarding the dividends of a stock.
 */
public class Dividend {
    /**
     * Data of the dividend being paid
     */
    private SimpleStringProperty date;

    /**
     * Quantity of shares held on the Ex-dividend date.
     */
    private SimpleFloatProperty quantity;

    /**
     * The amount paid to shareholders per share of the dividend
     */
    private SimpleFloatProperty paymentRate;

    /**
     * The value of the dividend as a whole.
     */
    private SimpleFloatProperty value;

    /**
     * Base constructor for the Dividend class
     */
    public Dividend(){
        this.date = new SimpleStringProperty();
        this.quantity = new SimpleFloatProperty();
        this.value = new SimpleFloatProperty();
        this.paymentRate = new SimpleFloatProperty();
    }

    /**
     * Overloaded constructor for the Dividend class
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

    /**
     * Overridden method to output the object as a string
     * @return string output
     */
    @Override
    public String toString(){
        return "Date : " + this.date + ", Quantity : " + this.quantity + ", Payment Rate : £" + this.paymentRate + ", Value : £" + this.value;
    }
}
