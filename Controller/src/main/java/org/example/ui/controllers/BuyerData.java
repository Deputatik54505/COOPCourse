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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.ui.models.*;

public class BuyerData {

    private Buyer currBuyer;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button userBasket;

    @FXML
    private Group home;

    @FXML
    private Circle userAvatar;

    @FXML
    private Button basketFavourites;

    @FXML
    private DatePicker userBirth;

    @FXML
    private Button userLogOut;

    @FXML
    private Label userName;

    @FXML
    private Button userSettings;

    @FXML
    private Label userSurname;

    @FXML
    void initialize() {
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userAvatar != null : "fx:id=\"userAvatar\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert basketFavourites != null : "fx:id=\"basketFavourites\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userBirth != null : "fx:id=\"userBirth\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userLogOut != null : "fx:id=\"userLogOut\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userSettings != null : "fx:id=\"userSettings\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userSurname != null : "fx:id=\"userSurname\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";

        //TODO load general data (name, surname, birth) from DB

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

        this.userSettings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BuyerSettingsSwitch().changeScene(currBuyer, event);
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
