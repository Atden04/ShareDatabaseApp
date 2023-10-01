package com.atden04.Java.ShareDatabaseApp.ModelViewController;

import com.atden04.Java.ShareDatabaseApp.DataModel.Person;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * The Model will handle the input and output of the data as well as containing the various DataModels
 */
public class Model {

    private ObservableList<Person> people;

    private void createPeople() {
        this.people = FXCollections.observableArrayList(
                new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person("Ethan", "Williams", "ethan.williams@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com")
        );
    }

    public void initialise() {
        this.createPeople();
    }

    public ObservableList<Person> getPeople(){
        return this.people;
    }

}
