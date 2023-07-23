package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.ui.controllers.MainPage;

import java.io.IOException;

public class NotAuthMainSwitch {
    public NotAuthMainSwitch() { }
    public void changeScene(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main_page.fxml"));
        loader.setController(new MainPage(stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}