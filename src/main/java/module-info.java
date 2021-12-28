module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires pdfbox;

    opens org.controller to javafx.fxml;
    exports org.controller;
    opens org.klassen to javafx.base;
}