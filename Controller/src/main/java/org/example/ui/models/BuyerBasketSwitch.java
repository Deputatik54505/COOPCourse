package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.ui.controllers.Basket;
import org.example.ui.controllers.BuyerData;

import java.io.IOException;

public class BuyerBasketSwitch {
    public BuyerBasketSwitch() { }

    public void changeScene(Buyer currBuyer, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/shopping_cart.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);

        Basket basket = loader.getController();
        if (currBuyer.isExist()) {
            basket.initBuyer(currBuyer);
        }

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(newScene);
        primaryStage.show();
    }
}
