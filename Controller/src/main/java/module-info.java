module Controller.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.zaxxer.hikari;
    requires java.desktop;
    requires org.postgresql.jdbc;


    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.ui.controllers;
    opens org.example.ui.controllers to javafx.fxml;
}