package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.product.Product;
import org.example.entities.user.User;
import org.example.tables.Users;
import org.example.forms.data.FData;
import org.example.forms.log.FLogIn;
import org.example.forms.passport.FPassport;
import org.example.forms.sign.FSignIn;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/shopping_cart.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        primaryStage.setTitle("Shop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Product product = new Product();
        product.loadById(1);
        //launch();
    }
}