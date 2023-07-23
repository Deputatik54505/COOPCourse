package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.SellerProduct;

import java.io.IOException;

public class SellerProductSwitch {
    public SellerProductSwitch() { }
    public void changeScene(Seller seller, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/seller_create_product.fxml"));
        loader.setController(new SellerProduct(seller, stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
