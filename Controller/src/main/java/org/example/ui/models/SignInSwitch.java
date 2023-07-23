package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.ui.controllers.SignIn;

import java.io.IOException;

public class SignInSwitch {
    public SignInSwitch() { }
    public void changeScene(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sign_in_form.fxml"));
        loader.setController(new SignIn(stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
