package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.Basket;

import java.io.IOException;

public class BasketSwitch {
    public BasketSwitch() { }
    public void changeScene(Buyer buyer, Seller seller, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/shopping_cart.fxml"));
        loader.setController(new Basket(buyer, seller, stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
