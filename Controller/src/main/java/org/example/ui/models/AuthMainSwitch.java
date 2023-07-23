package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.AuthMainPage;

import java.io.IOException;

public class AuthMainSwitch {
    public AuthMainSwitch() {}
    public void changeScene(Buyer buyer, Seller seller, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/auth_main_page.fxml"));
        loader.setController(new AuthMainPage(buyer, seller, stage));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
}
