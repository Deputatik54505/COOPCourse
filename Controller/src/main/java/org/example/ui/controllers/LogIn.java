package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import org.example.entities.user.User;
import org.example.ui.models.SceneSwitch;

public class LogIn {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtnRegister;

    @FXML
    private TextField UserMail;

    @FXML
    private PasswordField UserPassword;

    @FXML
    private PasswordField UserRepeatPassword;

    @FXML
    private Group home;

    @FXML
    private Button UserSignIn;

    @FXML
    private RadioButton userBuyer;

    @FXML
    private RadioButton userSeller;

    @FXML
    void initialize() {
        assert BtnRegister != null : "fx:id=\"BtnRegister\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert UserMail != null : "fx:id=\"UserMail\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert UserPassword != null : "fx:id=\"UserPassword\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert UserRepeatPassword != null : "fx:id=\"UserRepeatPassword\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert UserSignIn != null : "fx:id=\"UserSignIn\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert userBuyer != null : "fx:id=\"userBuyer\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert userSeller != null : "fx:id=\"userSeller\" was not injected: check your FXML file 'log_in_form.fxml'.";

        this.userBuyer.setSelected(true);
        this.userSeller.setSelected(false);

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

        this.userBuyer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userBuyer.setSelected(true);
                userSeller.setSelected(false);
            }
        });

        this.userSeller.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userBuyer.setSelected(false);
                userSeller.setSelected(true);
            }
        });

        this.BtnRegister.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    String type;
                    if (userBuyer.isSelected()) {
                        type = "buyer";
                    } else {
                        type = "seller";
                    }

                    User user = new User(
                            UserMail.getText(),
                            UserPassword.getText(),
                            type
                    );
                    user.selfRegistration(UserRepeatPassword.getText());
                    //TODO add the user to DB
                    new SceneSwitch().changeScene(event, "/fxml/auth_main_page.fxml");

                } catch (Exception e) {
                    System.out.println(e.toString());
                } finally {
                    UserMail.clear();
                    UserPassword.clear();
                    UserRepeatPassword.clear();
                }
            }
        });

        this.UserSignIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/sign_in_form.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

    }
}

