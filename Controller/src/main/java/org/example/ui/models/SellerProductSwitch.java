package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.SellerOrders;
import org.example.ui.controllers.SellerProduct;

import java.io.IOException;

public class SellerProductSwitch {
    public SellerProductSwitch() { }

    public void changeScene(Seller currSeller, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/seller_create_product.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);

        SellerProduct sellerProduct = loader.getController();
        if (currSeller.isExist()) {
            sellerProduct.initSeller(currSeller);
        }

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(newScene);
        primaryStage.show();
    }
}
