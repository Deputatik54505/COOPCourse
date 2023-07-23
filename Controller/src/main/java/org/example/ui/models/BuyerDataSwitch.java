package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.ui.controllers.BuyerData;

import java.io.IOException;

public class BuyerDataSwitch {
    public BuyerDataSwitch() { }
    public void changeScene(Buyer buyer, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/buyer_acc_data.fxml"));
        loader.setController(new BuyerData(buyer, stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
