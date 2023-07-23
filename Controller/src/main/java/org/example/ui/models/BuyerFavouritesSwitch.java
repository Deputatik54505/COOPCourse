package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.ui.controllers.BuyerFavourites;

import java.io.IOException;

public class BuyerFavouritesSwitch {
    public BuyerFavouritesSwitch() { }
    public void changeScene(Buyer buyer, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/buyer_acc_favourites.fxml"));
        loader.setController(new BuyerFavourites(buyer, stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
