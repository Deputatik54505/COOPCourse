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
import org.example.ui.models.DefaultSceneSwitch;

public class SignIn {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAuthorize;

    @FXML
    private Button userLogIn;

    @FXML
    private TextField userMail;

    @FXML
    private PasswordField userPassword;

    @FXML
    private Group home;

    @FXML
    void initialize() {
        assert btnAuthorize != null : "fx:id=\"btnAuthorize\" was not injected: check your FXML file 'sign_in_form.fxml'.";
        assert userLogIn != null : "fx:id=\"userLogIn\" was not injected: check your FXML file 'sign_in_form.fxml'.";
        assert userMail != null : "fx:id=\"userMail\" was not injected: check your FXML file 'sign_in_form.fxml'.";
        assert userPassword != null : "fx:id=\"userPassword\" was not injected: check your FXML file 'sign_in_form.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'sign_in_form.fxml'.";

        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new DefaultSceneSwitch().changeScene(event, "/fxml/main_page.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.btnAuthorize.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO signed in the user

            }
        });

        this.userLogIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new DefaultSceneSwitch().changeScene(event, "/fxml/log_in_form.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }

}
