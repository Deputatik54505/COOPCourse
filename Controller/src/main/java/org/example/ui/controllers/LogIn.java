package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.entities.user.User;
import org.example.ui.models.DefaultSceneSwitch;

public class LogIn {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegister;

    @FXML
    private Label registrationError;

    @FXML
    private TextField userMail;

    @FXML
    private PasswordField userPassword;

    @FXML
    private PasswordField userRepeatPassword;

    @FXML
    private Group home;

    @FXML
    private Button userSignIn;

    @FXML
    private RadioButton userBuyer;

    @FXML
    private RadioButton userSeller;

    @FXML
    void initialize() {
        assert registrationError != null : "fx:id=\"registrationError\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert userMail != null : "fx:id=\"userMail\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert userPassword != null : "fx:id=\"userPassword\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert userRepeatPassword != null : "fx:id=\"userRepeatPassword\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert userSignIn != null : "fx:id=\"userSignIn\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert userBuyer != null : "fx:id=\"userBuyer\" was not injected: check your FXML file 'log_in_form.fxml'.";
        assert userSeller != null : "fx:id=\"userSeller\" was not injected: check your FXML file 'log_in_form.fxml'.";

        this.userBuyer.setSelected(true);
        this.userSeller.setSelected(false);

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

        this.btnRegister.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    String type;
                    if (userBuyer.isSelected()) {
                        type = "Buyer";
                    } else {
                        type = "Seller";
                    }
                    User user = new User(
                            userMail.getText(),
                            userPassword.getText(),
                            type
                    );
                    user.selfRegistration(userRepeatPassword.getText());

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/auth_main_page.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    AuthMainPage authMainPage = loader.getController();
                    if (userBuyer.isSelected()) {
                        //TODO add the buyer to DB
                        authMainPage.initBuyer(new Buyer(user));
                    } else {
                        //TODO add the seller to DB
                        authMainPage.initSeller(new Seller(user));
                    }

                    Stage primaryStage = (Stage) btnRegister.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();

                } catch (Exception e) {
                    registrationError.setText(e.toString());
                } finally {
                    userMail.clear();
                    userPassword.clear();
                    userRepeatPassword.clear();
                }
            }
        });

        this.userSignIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new DefaultSceneSwitch().changeScene(event, "/fxml/sign_in_form.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

    }
}

