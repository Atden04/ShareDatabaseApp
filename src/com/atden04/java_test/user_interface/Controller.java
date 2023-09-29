package com.atden04.java_test.user_interface;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label label;

    public Controller() {
        System.out.println("Controller constructed");
    }

    @FXML
    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        System.out.println("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion+ ".");
        this.label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion+ ".");
    }
}
