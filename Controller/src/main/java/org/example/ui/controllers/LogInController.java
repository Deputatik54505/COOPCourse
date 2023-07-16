package org.example.ui.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.entities.users.Users;
import org.example.forms.log.FLogIn;
import org.example.ui.models.SceneSwitch;

public class LogInController {

    @FXML
    private Button BtnRegister;

    @FXML
    private Label UserLogIn;

    @FXML
    private TextField UserMail;

    @FXML
    private PasswordField UserPassword;

    @FXML
    private PasswordField UserRepeatPassword;

    @FXML
    private Label UserSignIn;

    @FXML
    void initialize() {
        this.BtnRegister.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO replace Users to table in the DB
                try {
                    FLogIn fLogIn = new FLogIn(new Users());
                    fLogIn.verify(
                            UserMail.getText(),
                            UserPassword.getText(),
                            UserRepeatPassword.getText()
                    );

                    new SceneSwitch().changeScene(event, "/fxml/main_page_authorized.fxml");

                } catch (Exception e) {
                    System.out.println(e.toString());
                } finally {
                    UserMail.clear();
                    UserPassword.clear();
                    UserRepeatPassword.clear();
                }
            }
        });
    }

}
