package org.example.ui.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
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

public class SellerSettings {
    private final Seller currSeller;

    private final Stage primaryStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker newDateBirth;

    @FXML
    private PasswordField newName;

    @FXML
    private PasswordField newSurname;

    @FXML
    private PasswordField userPassword;

    @FXML
    private PasswordField userPassword1;

    @FXML
    private Button confirmData;

    @FXML
    private Button confirmPassport;

    @FXML
    private PasswordField newCode;

    @FXML
    private PasswordField newNumber;

    @FXML
    private PasswordField newPublisher;

    @FXML
    private PasswordField newSeries;

    @FXML
    private Button createProduct;

    @FXML
    private Group home;

    @FXML
    private Circle userAvatar;

    @FXML
    private Button userBasket;

    @FXML
    private Button userData;

    @FXML
    private Button userGoods;

    @FXML
    private Button userLogOut;

    @FXML
    private Button userOrders;

    public SellerSettings(Seller seller, Stage stage) {
        this.currSeller = seller;
        this.primaryStage = stage;
    }

    @FXML
    void initialize() {
        assert confirmPassport != null : "fx:id=\"confirmPassport\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert confirmData != null : "fx:id=\"confirmData\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newDateBirth != null : "fx:id=\"newDateBirth\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newName != null : "fx:id=\"newName\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newSurname != null : "fx:id=\"newSurname\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userPassword != null : "fx:id=\"userPassword\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newCode != null : "fx:id=\"newCode\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newNumber != null : "fx:id=\"newNumber\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newPublisher != null : "fx:id=\"newPublisher\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newSeries != null : "fx:id=\"newSeries\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userPassword1 != null : "fx:id=\"userPassword1\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert createProduct != null : "fx:id=\"createProduct\" was not injected: check your FXML file 'seller_acc_settings.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'seller_acc_settings.fxml'.";
        assert userAvatar != null : "fx:id=\"userAvatar\" was not injected: check your FXML file 'seller_acc_settings.fxml'.";
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'seller_acc_settings.fxml'.";
        assert userData != null : "fx:id=\"userData\" was not injected: check your FXML file 'seller_acc_settings.fxml'.";
        assert userGoods != null : "fx:id=\"userGoods\" was not injected: check your FXML file 'seller_acc_settings.fxml'.";
        assert userLogOut != null : "fx:id=\"userLogOut\" was not injected: check your FXML file 'seller_acc_settings.fxml'.";
        assert userOrders != null : "fx:id=\"userOrders\" was not injected: check your FXML file 'seller_acc_settings.fxml'.";

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

        this.userData.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SellerDataSwitch().changeScene(currSeller, primaryStage);
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

        this.confirmData.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    //TODO insert this info into UserData
                    System.out.println(userPassword.getText());
                    System.out.println(newName.getText());
                    System.out.println(newSurname.getText());
                    System.out.println(newDateBirth.getValue().toString());
                } catch (Exception e) {
                    System.out.println(e.toString());
                } finally {
                    userPassword.clear();
                    newName.clear();
                    newSurname.clear();
                    newDateBirth.getEditor().clear();
                }
            }
        });

        this.confirmPassport.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    //TODO insert this into PassportData
                    System.out.println(userPassword1.getText());
                    System.out.println(newSeries.getText());
                    System.out.println(newNumber.getText());
                    System.out.println(newPublisher.getText());
                    System.out.println(newCode.getText());
                } catch (Exception e) {
                    System.out.println(e.toString());
                } finally {
                    userPassword1.clear();
                    newSeries.clear();
                    newNumber.clear();
                    newPublisher.clear();
                    newCode.clear();
                }
            }
        });
    }
}
