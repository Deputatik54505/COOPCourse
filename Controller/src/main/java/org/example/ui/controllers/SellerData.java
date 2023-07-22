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
import org.example.entities.seller.Seller;
import org.example.ui.models.SceneSwitch;

public class SellerData {

    private Seller currSeller;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createProduct;

    @FXML
    private Group home;

    @FXML
    private Label numCategories;

    @FXML
    private Label numProducts;

    @FXML
    private Circle userAvatar;

    @FXML
    private Button userBasket;

    @FXML
    private DatePicker userBirth;

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

    @FXML
    void initialize() {
        assert createProduct != null : "fx:id=\"createProduct\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert numCategories != null : "fx:id=\"numCategories\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert numProducts != null : "fx:id=\"numProducts\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userAvatar != null : "fx:id=\"userAvatar\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userBirth != null : "fx:id=\"userBirth\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userGoods != null : "fx:id=\"userGoods\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userLogOut != null : "fx:id=\"userLogOut\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userOrders != null : "fx:id=\"userOrders\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userSettings != null : "fx:id=\"userSettings\" was not injected: check your FXML file 'seller_acc_data.fxml'.";
        assert userSurname != null : "fx:id=\"userSurname\" was not injected: check your FXML file 'seller_acc_data.fxml'.";

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

        this.createProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/seller_create_product.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    SellerProduct sellerProduct = loader.getController();
                    if (currSeller.isExist()) {
                        sellerProduct.initSeller(currSeller);
                    }

                    Stage primaryStage = (Stage) createProduct.getScene().getWindow();
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
