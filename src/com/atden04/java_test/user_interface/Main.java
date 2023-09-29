package com.atden04.java_test.user_interface;

import com.atden04.java_test.res.ResourceManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {

    Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        FXMLLoader loader = new FXMLLoader(ResourceManager.getFxml("scene.fxml"));
        this.controller = new Controller();
        loader.setControllerFactory((Klass) -> this.controller);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(ResourceManager.getCss("style.css").toExternalForm());

        stage.setTitle("JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}