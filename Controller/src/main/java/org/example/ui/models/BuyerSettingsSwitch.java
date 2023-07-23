package org.example.ui.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.ui.controllers.BuyerSettings;

import java.io.IOException;

public class BuyerSettingsSwitch {
    public BuyerSettingsSwitch() { }

    public void changeScene(Buyer currBuyer, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/buyer_acc_settings.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);

        BuyerSettings buyerSettings = loader.getController();
        if (currBuyer.isExist()) {
            buyerSettings.initBuyer(currBuyer);
        }

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(newScene);
        primaryStage.show();
    }
}