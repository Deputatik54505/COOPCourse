package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.ui.models.SceneSwitch;

public class SignIn {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtnAuthorize;

    @FXML
    private Button UserLogIn;

    @FXML
    private TextField UserMail;

    @FXML
    private PasswordField UserPassword;

    @FXML
    private Group home;

    @FXML
    void initialize() {
        assert BtnAuthorize != null : "fx:id=\"BtnAuthorize\" was not injected: check your FXML file 'sign_in_form.fxml'.";
        assert UserLogIn != null : "fx:id=\"UserLogIn\" was not injected: check your FXML file 'sign_in_form.fxml'.";
        assert UserMail != null : "fx:id=\"UserMail\" was not injected: check your FXML file 'sign_in_form.fxml'.";
        assert UserPassword != null : "fx:id=\"UserPassword\" was not injected: check your FXML file 'sign_in_form.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'sign_in_form.fxml'.";

        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/main_page.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.BtnAuthorize.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO signed in the user

            }
        });

        this.UserLogIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/log_in_form.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }

}
