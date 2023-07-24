package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.ui.controllers.LogIn;

import java.io.IOException;

public class LogInSwitch {
    private final FXMLLoader loader;
    public LogInSwitch() {
        this.loader = new FXMLLoader();
    }
    public void changeScene(Stage stage) throws IOException {
        initLocation();
        initController(stage);
        stage.setScene(new Scene(this.loader.load()));
    }

    private void initLocation() {
        this.loader.setLocation(getClass().getResource("/fxml/log_in_form.fxml"));
    }

    private void initController(Stage stage) {
        this.loader.setController(new LogIn(stage));
    }
}
