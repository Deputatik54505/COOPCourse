package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.SellerOrders;

import java.io.IOException;

public class SellerOrdersSwitch {
    public SellerOrdersSwitch() { }
    public void changeScene(Seller seller, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/seller_acc_orders.fxml"));
        loader.setController(new SellerOrders(seller, stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
