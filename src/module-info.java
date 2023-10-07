module ShareDatabaseApp {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens com.atden04.Java.ShareDatabaseApp.ModelViewController to javafx.fxml;
    exports com.atden04.Java.ShareDatabaseApp.ModelViewController;
    exports com.atden04.Java.ShareDatabaseApp.res;
    exports com.atden04.Java.ShareDatabaseApp.DataModel;
    opens com.atden04.Java.ShareDatabaseApp.res to javafx.fxml;
}