package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.ui.controllers.SignIn;

import java.io.IOException;

public final class SignInSwitch {
    private final FXMLLoader loader;
    public SignInSwitch() {
        this.loader = new FXMLLoader();
    }
    public void changeScene(Stage stage) throws IOException {
        initLocation();
        initController(stage);
        stage.setScene(new Scene(this.loader.load()));
    }

    private void initLocation() {
        this.loader.setLocation(getClass().getResource("/fxml/sign_in_form.fxml"));
    }

    private void initController(Stage stage) {
        this.loader.setController(new SignIn(stage));
    }
}
