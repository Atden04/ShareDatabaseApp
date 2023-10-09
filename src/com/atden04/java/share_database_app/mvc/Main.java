package com.atden04.java.share_database_app.mvc;

import com.atden04.java.share_database_app.res.ResourceManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {

    Model model;
    Controller controller;

    @Override
    public void start(Stage stage) throws Exception {

        // Create the controller and model
        this.controller = new Controller();
        this.model = new Model();

        //Create FXML Loader and set the controller
        FXMLLoader loader = new FXMLLoader(ResourceManager.getFxml("scene.fxml"));
        this.controller = new Controller();
        loader.setControllerFactory((Klass) -> this.controller);

        //Load the root of the scene and create the scene itself
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setTitle("Share Database App v0.1");   //set title of stage (window)
        stage.setScene(scene);      //set the scene of the stage
        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("Closing the App...");
    }

    public static void main(String[] args) {
        launch(args);
    }
}