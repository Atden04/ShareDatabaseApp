package com.atden04.java.share_database_app.models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Class to store all data regarding the sale of a stock
 */
public class Sale {
    /**
     * Date of the sale of stock
     */
    private SimpleStringProperty date;

    /**
     * Quantity of stock sold
     */
    private SimpleFloatProperty quantity;

    /**
     * Value of the sale
     */
    private SimpleFloatProperty value;

    /**
     * Profit made from the sale
     */
    private SimpleFloatProperty profit;

    /**
     * Base constructor for the Sale class
     */
    public Sale() {
        this.date = new SimpleStringProperty();
        this.quantity = new SimpleFloatProperty();
        this.value = new SimpleFloatProperty();
        this.profit = new SimpleFloatProperty();
    }

    /**
     * Overloaded constructor for the Sale class
     * @param date Date of Sale
     * @param quantity Quantity of stock sold
     * @param value Value of the sale
     * @param cost Cost to buy the stock sold
     */
    public Sale(String date, float quantity, float value, float cost){
        this.date = new SimpleStringProperty(date);
        this.quantity = new SimpleFloatProperty(quantity);
        this.value = new SimpleFloatProperty(value);
        this.profit = new SimpleFloatProperty(this.value.get()-cost);
    }

    /**
     * Overridden method to output the object as a string
     * @return string output
     */
    @Override
    public String toString(){
        return "Date : "+this.date+", Quantity : "+this.quantity+", Sale : £"+this.value+", Profit : £"+this.profit;
    }
}
