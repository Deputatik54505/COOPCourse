package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.ui.models.*;

public class BuyerSettings {

    private Buyer currBuyer;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button basketFavourites;

    @FXML
    private Group home;

    @FXML
    private Button confirmDateBirth;

    @FXML
    private Button confirmMail;

    @FXML
    private Button confirmName;

    @FXML
    private Button confirmPassword;

    @FXML
    private Button confirmSurname;

    @FXML
    private Circle userAvatar;

    @FXML
    private Button userBasket;

    @FXML
    private Button userData;

    @FXML
    private Button userLogOut;

    @FXML
    void initialize() {
        assert basketFavourites != null : "fx:id=\"basketFavourites\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userAvatar != null : "fx:id=\"userAvatar\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userData != null : "fx:id=\"userData\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userLogOut != null : "fx:id=\"userLogOut\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";

        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BuyerHomeSwitch().changeScene(currBuyer, event);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userBasket.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BuyerBasketSwitch().changeScene(currBuyer, event);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userData.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BuyerDataSwitch().changeScene(currBuyer, event);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.basketFavourites.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BuyerFavouritesSwitch().changeScene(currBuyer, event);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userLogOut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new DefaultSceneSwitch().changeScene(event, "/fxml/main_page.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });
    }

    public void initBuyer(Buyer buyer) {
        this.currBuyer = buyer;
    }

}
