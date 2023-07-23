package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.ui.controllers.LogIn;

import java.io.IOException;

public class LogInSwitch {
    public LogInSwitch() { }
    public void changeScene(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/log_in_form.fxml"));
        loader.setController(new LogIn(stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
