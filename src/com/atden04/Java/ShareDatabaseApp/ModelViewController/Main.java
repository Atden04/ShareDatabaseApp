package com.atden04.Java.ShareDatabaseApp.ModelViewController;

import com.atden04.Java.ShareDatabaseApp.res.ResourceManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

//Used the following links as examples to follow:
//  https://docs.oracle.com/javafx/2/fxml_get_started/fxml_tutorial_intermediate.htm
//  https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
public class Main extends Application {

    Model model;
    Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        //Create the controller, view and model
        this.controller = new Controller();
        this.model= new Model();

        //create FXML loader and set controller.
        FXMLLoader loader = new FXMLLoader(ResourceManager.getFxml("scene.fxml"));
        loader.setControllerFactory((Klass) -> this.controller);

        //load and create the scene as well as adding the style sheet.
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(ResourceManager.getCss("style.css").toExternalForm());


        this.controller.initialise(this.model, stage);
        this.model.initialise(this.controller);

        stage.setTitle("Table View Tutorial");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}