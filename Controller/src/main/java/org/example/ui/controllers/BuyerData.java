package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class BuyerData {

    private final Buyer currBuyer;

    private final Stage primaryStage;

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
    private Button basketFavourites;

    @FXML
    private Button userLogOut;

    @FXML
    private Label userName;

    @FXML
    private Button userSettings;

    @FXML
    private Label userSurname;

    public BuyerData(Buyer buyer, Stage stage) {
        this.currBuyer = buyer;
        this.primaryStage = stage;
    }

    @FXML
    void initialize() {
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userAvatar != null : "fx:id=\"userAvatar\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert basketFavourites != null : "fx:id=\"basketFavourites\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userLogOut != null : "fx:id=\"userLogOut\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userSettings != null : "fx:id=\"userSettings\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userSurname != null : "fx:id=\"userSurname\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert passportCode != null : "fx:id=\"passportCode\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert passportNumber != null : "fx:id=\"passportNumber\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert passportPublisher != null : "fx:id=\"passportPublisher\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert passportSeries != null : "fx:id=\"passportSeries\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";
        assert userBirth != null : "fx:id=\"userBirth\" was not injected: check your FXML file 'buyer_acc_data.fxml'.";

        //TODO use general data (name, surname, birth) from DB
        //var generalData = currBuyer.user.data.represent();
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
                    new AuthMainSwitch(
                            currBuyer,
                            new Seller(new User("", "", "None")))
                            .changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userBasket.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BasketSwitch(
                            currBuyer,
                            new Seller(new User("", "", "None")))
                            .changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.basketFavourites.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BuyerFavouritesSwitch(currBuyer).changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userSettings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BuyerSettingsSwitch(currBuyer).changeScene(primaryStage);
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
