package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.SellerProduct;

import java.io.IOException;

public class SellerProductSwitch {
    private final FXMLLoader loader;

    private final Seller currSeller;
    public SellerProductSwitch(Seller seller) {
        this.loader = new FXMLLoader();
        this.currSeller = seller;
    }
    public void changeScene(Stage stage) throws IOException {
        initLocation();
        initController(stage);
        stage.setScene(new Scene(this.loader.load()));
    }

    private void initLocation() {
        this.loader.setLocation(getClass().getResource("/fxml/seller_create_product.fxml"));
    }

    private void initController(Stage stage) {
        this.loader.setController(new SellerProduct(this.currSeller, stage));
    }
}
