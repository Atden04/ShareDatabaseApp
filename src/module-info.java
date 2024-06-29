module ShareDatabaseApp {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    exports com.atden04.java.share_database_app.mvc;
    exports com.atden04.java.share_database_app.res;
    exports com.atden04.java.share_database_app.models;
    opens com.atden04.java.share_database_app.mvc to javafx.fxml;
    opens com.atden04.java.share_database_app.res to javafx.fxml;
    exports com.atden04.java.share_database_app.enums;
}