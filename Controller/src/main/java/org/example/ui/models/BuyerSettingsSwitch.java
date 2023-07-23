package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.ui.controllers.BuyerSettings;

import java.io.IOException;

public class BuyerSettingsSwitch {
    public BuyerSettingsSwitch() { }
    public void changeScene(Buyer buyer, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/buyer_acc_settings.fxml"));
        loader.setController(new BuyerSettings(buyer, stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
