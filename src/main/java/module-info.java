module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires pdfbox;
    requires java.desktop;
    requires itextpdf;

    opens org.controller to javafx.fxml;
    exports org.controller;
    opens org.klassen to javafx.base;
}