package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.SellerData;

import java.io.IOException;

public class SellerDataSwitch {
    private final FXMLLoader loader;

    private final Seller currSeller;
    public SellerDataSwitch(Seller seller) {
        this.loader = new FXMLLoader();
        this.currSeller = seller;
    }
    public void changeScene(Stage stage) throws IOException {
        initLocation();
        initController(stage);
        stage.setScene(new Scene(this.loader.load()));
    }

    private void initLocation() {
        this.loader.setLocation(getClass().getResource("/fxml/seller_acc_data.fxml"));
    }

    private void initController(Stage stage) {
        this.loader.setController(new SellerData(this.currSeller, stage));
    }
}
