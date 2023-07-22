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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.models.SceneSwitch;

public class SellerProduct {

    private Seller currSeller;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addProduct;

    @FXML
    private Group home;

    @FXML
    private TextField productCost;

    @FXML
    private TextField productDesc;

    @FXML
    private TextField productTitle;

    @FXML
    private TextField productsNumber;

    @FXML
    private TextField typeCategory;

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

    @FXML
    private Button userSettings;

    @FXML
    void initialize() {
        assert addProduct != null : "fx:id=\"addProduct\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert productCost != null : "fx:id=\"productCost\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert productDesc != null : "fx:id=\"productDesc\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert productTitle != null : "fx:id=\"productTitle\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert productsNumber != null : "fx:id=\"productsNumber\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert typeCategory != null : "fx:id=\"typeCategory\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert userAvatar != null : "fx:id=\"userAvatar\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert userData != null : "fx:id=\"userData\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert userGoods != null : "fx:id=\"userGoods\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert userLogOut != null : "fx:id=\"userLogOut\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert userOrders != null : "fx:id=\"userOrders\" was not injected: check your FXML file 'seller_create_product.fxml'.";
        assert userSettings != null : "fx:id=\"userSettings\" was not injected: check your FXML file 'seller_create_product.fxml'.";

        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/auth_main_page.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    AuthMainPage authMainPage = loader.getController();
                    if (currSeller.isExist()) {
                        authMainPage.initSeller(currSeller);
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
                    if (currSeller.isExist()) {
                        basket.initSeller(currSeller);
                    }

                    Stage primaryStage = (Stage) userBasket.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userData.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/seller_acc_orders.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    SellerData sellerData = loader.getController();
                    if (currSeller.isExist()) {
                        sellerData.initSeller(currSeller);
                    }

                    Stage primaryStage = (Stage) userData.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userGoods.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/seller_acc_goods.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    SellerGoods sellerGoods = loader.getController();
                    if (currSeller.isExist()) {
                        sellerGoods.initSeller(currSeller);
                    }

                    Stage primaryStage = (Stage) userGoods.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userOrders.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/seller_acc_orders.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    SellerOrders sellerOrders = loader.getController();
                    if (currSeller.isExist()) {
                        sellerOrders.initSeller(currSeller);
                    }

                    Stage primaryStage = (Stage) userOrders.getScene().getWindow();
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
                    loader.setLocation(getClass().getResource("/fxml/seller_acc_settings.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    SellerSettings sellerSettings = loader.getController();
                    if (currSeller.isExist()) {
                        sellerSettings.initSeller(currSeller);
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

    public void initSeller(Seller seller) {
        this.currSeller = seller;
    }

}
