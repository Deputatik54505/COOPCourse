package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.entities.user.User;
import org.example.ui.controllers.AuthMainPage;
import org.example.ui.controllers.MainPage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main_page.fxml"));
        loader.setController(new MainPage(primaryStage));
        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("Shop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}