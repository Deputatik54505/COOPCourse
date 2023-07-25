package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.ui.controllers.BuyerFavourites;

import java.io.IOException;

public final class BuyerFavouritesSwitch {
    private final FXMLLoader loader;
    private final Buyer currBuyer;
    public BuyerFavouritesSwitch(Buyer buyer) {
        this.loader = new FXMLLoader();
        this.currBuyer = buyer;
    }
    public void changeScene(Stage stage) throws IOException {
        initLocation();
        initController(stage);
        stage.setScene(new Scene(this.loader.load()));
    }

    private void initLocation() {
        this.loader.setLocation(getClass().getResource("/fxml/buyer_acc_favourites.fxml"));
    }

    private void initController(Stage stage) {
        this.loader.setController(new BuyerFavourites(this.currBuyer, stage));
    }
}
