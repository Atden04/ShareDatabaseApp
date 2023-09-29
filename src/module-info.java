module Test.Java {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens com.atden04.java_test.user_interface to javafx.fxml;
    exports com.atden04.java_test.user_interface;
    exports com.atden04.java_test.res;
    opens com.atden04.java_test.res to javafx.fxml;
}