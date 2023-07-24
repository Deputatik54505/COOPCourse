package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.ui.controllers.BuyerSettings;

import java.io.IOException;

public class BuyerSettingsSwitch {
    private final FXMLLoader loader;

    private final Buyer currBuyer;
    public BuyerSettingsSwitch(Buyer buyer) {
        this.loader = new FXMLLoader();
        this.currBuyer = buyer;
    }
    public void changeScene(Stage stage) throws IOException {
        initLocation();
        initController(stage);
        stage.setScene(new Scene(this.loader.load()));
    }

    private void initLocation() {
        this.loader.setLocation(getClass().getResource("/fxml/buyer_acc_settings.fxml"));
    }

    private void initController(Stage stage) {
        this.loader.setController(new BuyerSettings(this.currBuyer, stage));
    }
}
