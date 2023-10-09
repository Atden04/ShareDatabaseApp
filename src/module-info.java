module Test.Java {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens com.atden04.java.share_database_app.mvc to javafx.fxml;
    exports com.atden04.java.share_database_app.mvc;
    exports com.atden04.java.share_database_app.res;
    opens com.atden04.java.share_database_app.res to javafx.fxml;
}