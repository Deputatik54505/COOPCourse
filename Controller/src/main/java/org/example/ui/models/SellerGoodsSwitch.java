package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.SellerGoods;

import java.io.IOException;

public class SellerGoodsSwitch {
    public SellerGoodsSwitch() { }
    public void changeScene(Seller seller, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/seller_acc_goods.fxml"));
        loader.setController(new SellerGoods(seller, stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
