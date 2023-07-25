package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.BuyerMainPage;
import org.example.ui.controllers.SellerMainPage;

import java.io.IOException;

public class SellerMainSwitch {
    private final FXMLLoader loader;

    private final Seller currSeller;

    public SellerMainSwitch(Seller seller) {
        this.loader = new FXMLLoader();
        this.currSeller = seller;
    }
    public void changeScene(Stage stage) throws IOException {
        initLocation();
        initController(stage);
        stage.setScene(new Scene(this.loader.load()));
    }
    private void initLocation() {
        this.loader.setLocation(getClass().getResource("/fxml/seller_main_page.fxml"));
    }
    private void initController(Stage stage) {
        this.loader.setController(new SellerMainPage(this.currSeller, stage));
    }
}
