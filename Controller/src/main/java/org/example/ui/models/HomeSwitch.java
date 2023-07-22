package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.ui.controllers.AuthMainPage;

import java.io.IOException;

public class HomeSwitch {
    public HomeSwitch() { }

    public void changeScene(Buyer currBuyer, Seller currSeller, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/auth_main_page.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);

        AuthMainPage authMainPage = loader.getController();
        if (currBuyer.isExist()) {
            authMainPage.initBuyer(currBuyer);
        } else if (currSeller.isExist()) {
            authMainPage.initSeller(currSeller);
        }

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(newScene);
        primaryStage.show();
    }
}
