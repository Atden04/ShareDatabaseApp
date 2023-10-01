module Test.Java {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens com.atden04.Java.ShareDatabaseApp.ModelViewController to javafx.fxml;
    exports com.atden04.Java.ShareDatabaseApp.ModelViewController;
    exports com.atden04.Java.ShareDatabaseApp.res;
    opens com.atden04.Java.ShareDatabaseApp.res to javafx.fxml;
}