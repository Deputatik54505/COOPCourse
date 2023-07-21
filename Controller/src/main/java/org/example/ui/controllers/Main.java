package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.Group;
import javafx.scene.text.Font;
import org.example.ui.models.SceneSwitch;

public class Main {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button UserLogIn;

    @FXML
    private TextField UserSearch;

    @FXML
    private Button UserSignIn;

    @FXML
    private TilePane listOfProducts;

    @FXML
    private Group home;

    @FXML
    private Font x1;

    @FXML
    void initialize() {
        assert UserLogIn != null : "fx:id=\"UserLogIn\" was not injected: check your FXML file 'main_page.fxml'.";
        assert UserSearch != null : "fx:id=\"UserSearch\" was not injected: check your FXML file 'main_page.fxml'.";
        assert UserSignIn != null : "fx:id=\"UserSignIn\" was not injected: check your FXML file 'main_page.fxml'.";
        assert listOfProducts != null : "fx:id=\"listOfProducts\" was not injected: check your FXML file 'main_page.fxml'.";
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'main_page.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'main_page.fxml'.";

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

