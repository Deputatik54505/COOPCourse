package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.SellerData;

import java.io.IOException;

public class SellerDataSwitch {
    public SellerDataSwitch() { }
    public void changeScene(Seller seller, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/seller_acc_data.fxml"));
        loader.setController(new SellerData(seller, stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
