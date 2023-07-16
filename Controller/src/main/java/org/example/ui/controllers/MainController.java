package org.example.ui.controllers;

import org.example.ui.models.SceneSwitch;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainController {

    @FXML
    private Label UserLogIn;

    @FXML
    private Label UserSignIn;

    @FXML
    void initialize() {

        this.UserLogIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    SceneSwitch.changeScene(event, "/fxml/log_in_form.fxml", "Shop");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.UserSignIn.setOnMouseClicked(event -> {
            System.out.println("sign in");
        });

    }

}
