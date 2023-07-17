package org.example.ui.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.tables.Users;
import org.example.forms.sign.FSignIn;
import org.example.ui.models.SceneSwitch;

public class SignInController {

    @FXML
    private Button BtnAuthorize;

    @FXML
    private Label UserLogIn;

    @FXML
    private TextField UserMail;

    @FXML
    private PasswordField UserPassword;

    @FXML
    private Label UserSignIn;

    @FXML
    void initialize() {
        this.BtnAuthorize.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO replace Users to table in the DB
                try {
                    FSignIn fSignIn = new FSignIn(new Users());
                    fSignIn.verify(
                            UserMail.getText(),
                            UserPassword.getText()
                    );

                    new SceneSwitch().changeScene(event, "/fxml/main_page_authorized.fxml");

                } catch (Exception e) {
                    System.out.println(e.toString());
                } finally {
                    UserMail.clear();
                    UserPassword.clear();
                }
            }
        });

    }

}
