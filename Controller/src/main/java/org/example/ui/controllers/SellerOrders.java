package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import org.example.ui.models.SceneSwitch;

public class SellerOrders {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createProduct;

    @FXML
    private Group home;

    @FXML
    private TilePane listOfProducts;

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
    private Button userSettings;

    @FXML
    void initialize() {
        assert createProduct != null : "fx:id=\"createProduct\" was not injected: check your FXML file 'seller_acc_orders.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'seller_acc_orders.fxml'.";
        assert listOfProducts != null : "fx:id=\"listOfProducts\" was not injected: check your FXML file 'seller_acc_orders.fxml'.";
        assert userAvatar != null : "fx:id=\"userAvatar\" was not injected: check your FXML file 'seller_acc_orders.fxml'.";
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'seller_acc_orders.fxml'.";
        assert userData != null : "fx:id=\"userData\" was not injected: check your FXML file 'seller_acc_orders.fxml'.";
        assert userGoods != null : "fx:id=\"userGoods\" was not injected: check your FXML file 'seller_acc_orders.fxml'.";
        assert userLogOut != null : "fx:id=\"userLogOut\" was not injected: check your FXML file 'seller_acc_orders.fxml'.";
        assert userSettings != null : "fx:id=\"userSettings\" was not injected: check your FXML file 'seller_acc_orders.fxml'.";

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

        this.userBasket.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/shopping_cart.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userData.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/seller_acc_data.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userGoods.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/seller_acc_goods.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.createProduct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/seller_create_product.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userSettings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/seller_acc_settings.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.listOfProducts.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (listOfProducts.getWidth() <= 500) {
                    listOfProducts.setPrefTileWidth(listOfProducts.getWidth() - 100);
                }
            }
        });

    }

}
