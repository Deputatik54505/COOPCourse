package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.AuthMainPage;
import org.example.ui.controllers.Basket;

import java.io.IOException;

public class SellerBasketSwitch {
    public SellerBasketSwitch() { }

    public void changeScene(Seller currSeller, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/shopping_cart.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);

        Basket basket = loader.getController();
        if (currSeller.isExist()) {
            basket.initSeller(currSeller);
        }

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(newScene);
        primaryStage.show();
    }
}
