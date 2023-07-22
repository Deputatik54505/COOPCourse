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
import org.example.entities.seller.Seller;
import org.example.ui.models.SceneSwitch;

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

        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/auth_main_page.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    AuthMainPage authMainPage = loader.getController();
                    if (currBuyer.isExist()) {
                        authMainPage.initBuyer(currBuyer);
                    }

                    Stage primaryStage = (Stage) home.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userBasket.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/shopping_cart.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    Basket basket = loader.getController();
                    if (currBuyer.isExist()) {
                        basket.initBuyer(currBuyer);
                    }

                    Stage primaryStage = (Stage) userBasket.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.basketFavourites.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/buyer_acc_favourites.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    BuyerFavourites buyerFavourites = loader.getController();
                    if (currBuyer.isExist()) {
                        buyerFavourites.initBuyer(currBuyer);
                    }

                    Stage primaryStage = (Stage) basketFavourites.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userSettings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/buyer_acc_settings.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    BuyerSettings buyerSettings = loader.getController();
                    if (currBuyer.isExist()) {
                        buyerSettings.initBuyer(currBuyer);
                    }

                    Stage primaryStage = (Stage) userSettings.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userLogOut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/main_page.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    Stage primaryStage = (Stage) userLogOut.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
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
