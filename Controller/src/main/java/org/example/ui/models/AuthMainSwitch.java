package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.AuthMainPage;
import org.example.validation.exceptions.UserNotFoundExc;

import java.io.IOException;

public class AuthMainSwitch {
    private final FXMLLoader loader;

    private final Buyer currBuyer;

    private final Seller currSeller;
    public AuthMainSwitch(Buyer buyer, Seller seller) {
        this.loader = new FXMLLoader();
        this.currBuyer = buyer;
        this.currSeller = seller;
    }
    public void changeScene(Stage stage) throws IOException {
        initLocation();
        initController(stage);
        stage.setScene(new Scene(this.loader.load()));
    }
    private void initLocation() {
        this.loader.setLocation(getClass().getResource("/fxml/auth_main_page.fxml"));
    }
    private void initController(Stage stage) {
        this.loader.setController(new AuthMainPage(this.currBuyer, this.currSeller, stage));
    }
}
