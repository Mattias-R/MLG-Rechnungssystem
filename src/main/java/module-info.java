module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.controller to javafx.fxml;
    exports org.controller;
}