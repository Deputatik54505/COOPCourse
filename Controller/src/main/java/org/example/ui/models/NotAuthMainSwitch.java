package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.ui.controllers.MainPage;

import java.io.IOException;

public class NotAuthMainSwitch {
    private final FXMLLoader loader;
    public NotAuthMainSwitch() {
        this.loader = new FXMLLoader();
    }
    public void changeScene(Stage stage) throws IOException {
        initLocation();
        initController(stage);
        stage.setScene(new Scene(this.loader.load()));
    }

    private void initLocation() {
        this.loader.setLocation(getClass().getResource("/fxml/main_page.fxml"));
    }

    private void initController(Stage stage) {
        this.loader.setController(new MainPage(stage));
    }
}