package com.atden04.java.share_database_app.models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Class to store all data regarding the purchases of a stock
 */
public class Purchase {
    /**
     * Date of the purchase of stock
     */
    private SimpleStringProperty date;

    /**
     * Quantity of stock bought
     */
    private SimpleFloatProperty quantity;

    /**
     * Cost of the stock bought
     */
    private SimpleFloatProperty cost;

    /**
     * Average (mean) cost of each share
     */
    private SimpleFloatProperty costPerShare;

    /**
     * Base constructor for the Purchase class
     */
    public Purchase() {
        this.date = new SimpleStringProperty();
        this.quantity = new SimpleFloatProperty();
        this.cost = new SimpleFloatProperty();
        this.costPerShare = new SimpleFloatProperty();
    }

    /**
     * Overloaded constructor for the Purchase class
     * @param date Date of Purchase
     * @param quantity Quantity of shares purchased
     * @param cost Cost of shares purchased
     */
    public Purchase(String date, float quantity, float cost){
        this.date = new SimpleStringProperty(date);
        this.quantity = new SimpleFloatProperty(quantity);
        this.cost = new SimpleFloatProperty(cost);
        this.costPerShare = new SimpleFloatProperty(this.cost.get()/this.quantity.get());
    }

    /**
     * Overridden method to output the object as a string
     * @return string output
     */
    @Override
    public String toString(){
        return "Date : "+this.date+", Quantity : "+this.quantity+", Cost : £"+this.cost+", Cost per Share : £"+this.costPerShare;
    }
}
