package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.SellerOrders;

import java.io.IOException;

public class SellerOrdersSwitch {
    private final FXMLLoader loader;

    private final Seller currSeller;
    public SellerOrdersSwitch(Seller seller) {
        this.loader = new FXMLLoader();
        this.currSeller = seller;
    }
    public void changeScene(Stage stage) throws IOException {
        initLocation();
        initController(stage);
        stage.setScene(new Scene(this.loader.load()));
    }

    private void initLocation() {
        this.loader.setLocation(getClass().getResource("/fxml/seller_acc_orders.fxml"));
    }

    private void initController(Stage stage) {
        this.loader.setController(new SellerOrders(this.currSeller, stage));
    }
}
