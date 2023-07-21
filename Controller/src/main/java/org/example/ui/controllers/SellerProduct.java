package org.example.ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class SellerProduct {

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

    }

}
