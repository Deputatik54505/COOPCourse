package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.BuyerData;
import org.example.ui.controllers.SellerData;

import java.io.IOException;

public class AccountSwitch {
    public AccountSwitch() { }

    public void changeScene(Buyer currBuyer, Seller currSeller, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        if (currBuyer.isExist()) {
            loader.setLocation(getClass().getResource("/fxml/buyer_acc_data.fxml"));
            Parent root = loader.load();
            Scene newScene = new Scene(root);

            BuyerData buyerData = loader.getController();
            buyerData.initBuyer(currBuyer);

            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(newScene);
            primaryStage.show();
        } else if (currSeller.isExist()) {
            loader.setLocation(getClass().getResource("/fxml/seller_acc_data.fxml"));
            Parent root = loader.load();
            Scene newScene = new Scene(root);

            SellerData sellerData = loader.getController();
            sellerData.initSeller(currSeller);

            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(newScene);
            primaryStage.show();
        }

    }
}
