package org.example.ui.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.entities.user.User;
import org.example.ui.models.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SellerData {
    private final Seller currSeller;

    private final Stage primaryStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createProduct;

    @FXML
    private Group home;

    @FXML
    private Label passportCode;

    @FXML
    private Label passportNumber;

    @FXML
    private Label passportPublisher;

    @FXML
    private Label passportSeries;

    @FXML
    private Label userBirth;

    @FXML
    private Circle userAvatar;

    @FXML
    private Button userBasket;

    @FXML
    private Button userGoods;

    @FXML
    private Button userLogOut;

    @FXML
    private Label userName;

    @FXML
    private Button userOrders;

    @FXML
    private Button userSettings;

    @FXML
    private Label userSurname;

    public SellerData(Seller seller, Stage stage) {
        this.currSeller = seller;
        this.primaryStage = stage;
    }

    @FXML
    void initialize() {
        assert createProduct != null : "fx:id=\"createProduct\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userAvatar != null : "fx:id=\"userAvatar\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userBirth != null : "fx:id=\"userBirth\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userGoods != null : "fx:id=\"userGoods\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userLogOut != null : "fx:id=\"userLogOut\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userOrders != null : "fx:id=\"userOrders\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userSettings != null : "fx:id=\"userSettings\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userSurname != null : "fx:id=\"userSurname\" was not injected: check your FXML file 'seller_acc_data.fxml'.";

        //TODO use general data (name, surname, birth, number of categories, number of products) from DB
        //var generalData = currSeller.user.data.represent();
        this.userName.setText("none");
        this.userSurname.setText("none");
        this.userBirth.setText("none");

        this.passportSeries.setText("none");
        this.passportNumber.setText("none");
        this.passportPublisher.setText("none");
        this.passportCode.setText("none");
        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new AuthMainSwitch().changeScene(
                            new Buyer(new User("", "", "None")),
                            currSeller,
                            primaryStage
                    );
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userBasket.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BasketSwitch().changeScene(
                            new Buyer(new User("", "", "None")),
                            currSeller,
                            primaryStage
                    );
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userGoods.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SellerGoodsSwitch().changeScene(currSeller, primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userOrders.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SellerOrdersSwitch().changeScene(currSeller, primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.createProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SellerProductSwitch().changeScene(currSeller, primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userSettings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SellerSettingsSwitch().changeScene(currSeller, primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userLogOut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new NotAuthMainSwitch().changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });
    }
}
