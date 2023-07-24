package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.SellerGoods;

import java.io.IOException;

public class SellerGoodsSwitch {
    private final FXMLLoader loader;

    private final Seller currSeller;
    public SellerGoodsSwitch(Seller seller) {
        this.loader = new FXMLLoader();
        this.currSeller = seller;
    }
    public void changeScene(Stage stage) throws IOException {
        initLocation();
        initController(stage);
        stage.setScene(new Scene(this.loader.load()));
    }

    private void initLocation() {
        this.loader.setLocation(getClass().getResource("/fxml/seller_acc_goods.fxml"));
    }

    private void initController(Stage stage) {
        this.loader.setController(new SellerGoods(this.currSeller, stage));
    }
}
