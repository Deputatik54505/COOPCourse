package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entities.user.User;
import org.example.ui.models.LogInSwitch;
import org.example.ui.models.NotAuthMainSwitch;

public class SignIn {
    private final Stage primaryStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAuthorize;

    @FXML
    private Label authorizationError;

    @FXML
    private Button userLogIn;

    @FXML
    private TextField userMail;

    @FXML
    private PasswordField userPassword;

    @FXML
    private Group home;

    public SignIn(Stage stage) {
        this.primaryStage = stage;
    }

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
                    new NotAuthMainSwitch().changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.btnAuthorize.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    //TODO check user's type
                    User user = new User(
                            userMail.getText(),
                            userPassword.getText(),
                            ""
                    );
                    user.selfAuthorization();
                } catch (Exception e) {
                    authorizationError.setText(e.toString());
                } finally {
                    userMail.clear();
                    userPassword.clear();
                }
            }
        });

        this.userLogIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new LogInSwitch().changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }

}
