package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.SellerData;
import org.example.ui.controllers.SellerGoods;

import java.io.IOException;

public class SellerGoodsSwitch {
    public SellerGoodsSwitch() { }

    public void changeScene(Seller currSeller, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/seller_acc_goods.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);

        SellerGoods sellerGoods = loader.getController();
        if (currSeller.isExist()) {
            sellerGoods.initSeller(currSeller);
        }

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(newScene);
        primaryStage.show();
    }
}
