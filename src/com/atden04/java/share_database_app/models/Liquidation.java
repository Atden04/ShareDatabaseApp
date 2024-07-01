package com.atden04.java.share_database_app.models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Class to store all data regarding the liquidations of a stock.
 */
public class Liquidation {
    /**
     * Date of the liquidation payment being paid
     */
    private SimpleStringProperty date;

    /**
     * Quantity of shares held at the point of liquidation
     */
    private SimpleFloatProperty quantity;

    /**
     * The value of the liquidation payment
     */
    private SimpleFloatProperty value;

    /**
     * Base constructor for the Liquidation class
     */
    public Liquidation() {
        this.date = new SimpleStringProperty();
        this.quantity = new SimpleFloatProperty();
        this.value = new SimpleFloatProperty();
    }

    /**
     * Overloaded constructor for the Liquidation class
     * @param date Date Liquidation payment received
     * @param quantity Quantity of shares held
     * @param value Value of Liquidation payment
     */
    public Liquidation(String date, float quantity, float value){
        this.date = new SimpleStringProperty(date);
        this.quantity = new SimpleFloatProperty(quantity);
        this.value = new SimpleFloatProperty(value);
    }

    /**
     * Overridden method to output the object as a string
     * @return string output
     */
    @Override
    public String toString(){
        return "Date : "+this.date+", Quantity : "+this.quantity+", Payment : £"+this.value;
    }
}
