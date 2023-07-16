module Controller.main {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.ui.controllers;
    opens org.example.ui.controllers to javafx.fxml;
}