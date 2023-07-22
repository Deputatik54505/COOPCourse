package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.ui.models.SceneSwitch;

public class BuyerFavourites {

    private Buyer currBuyer;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Group home;

    @FXML
    private Circle userAvatar;

    @FXML
    private TilePane listOfFavourites;

    @FXML
    private Button userBasket;

    @FXML
    private Button userData;

    @FXML
    private Button userLogOut;

    @FXML
    private Button userSettings;

    @FXML
    void initialize() {
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'buyer_acc_favourites.fxml'.";
        assert listOfFavourites != null : "fx:id=\"listOfFavourites\" was not injected: check your FXML file 'buyer_acc_favourites.fxml'.";
        assert userAvatar != null : "fx:id=\"userAvatar\" was not injected: check your FXML file 'buyer_acc_favourites.fxml'.";
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'buyer_acc_favourites.fxml'.";
        assert userData != null : "fx:id=\"userData\" was not injected: check your FXML file 'buyer_acc_favourites.fxml'.";
        assert userLogOut != null : "fx:id=\"userLogOut\" was not injected: check your FXML file 'buyer_acc_favourites.fxml'.";
        assert userSettings != null : "fx:id=\"userSettings\" was not injected: check your FXML file 'buyer_acc_favourites.fxml'.";

        BackgroundImage addToCart = new BackgroundImage(
                new Image("/assets/image/icons/add-to-cart.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

        for (int i = 0; i < 20; i++) {
            VBox product = this.addProduct(i, addToCart);
            this.listOfFavourites.getChildren().add(product);
        }

        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/auth_main_page.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    AuthMainPage authMainPage = loader.getController();
                    if (currBuyer.isExist()) {
                        authMainPage.initBuyer(currBuyer);
                    }

                    Stage primaryStage = (Stage) home.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userBasket.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/shopping_cart.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    Basket basket = loader.getController();
                    if (currBuyer.isExist()) {
                        basket.initBuyer(currBuyer);
                    }

                    Stage primaryStage = (Stage) userBasket.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userData.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/buyer_acc_data.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    BuyerData buyerData = loader.getController();
                    if (currBuyer.isExist()) {
                        buyerData.initBuyer(currBuyer);
                    }

                    Stage primaryStage = (Stage) userData.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userSettings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/buyer_acc_settings.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    BuyerSettings buyerSettings = loader.getController();
                    if (currBuyer.isExist()) {
                        buyerSettings.initBuyer(currBuyer);
                    }

                    Stage primaryStage = (Stage) userSettings.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userLogOut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/main_page.fxml"));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);

                    Stage primaryStage = (Stage) userLogOut.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });
    }

    public void initBuyer(Buyer buyer) {
        this.currBuyer = buyer;
    }

    public VBox addProduct(int i, BackgroundImage addToCart) {
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image("/assets/image/logo.jpg"), //BD
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );

        Button add = new Button();
        add.setPrefSize(32.0, 32.0);
        add.setBackground(new Background(addToCart));
        add.setCursor(Cursor.HAND);

        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO add to User's shopping cart
            }
        });

        VBox container = new VBox();
        TilePane.setMargin(container, new Insets(4));

        Label title = new Label("Title");
        title.setTextFill(Paint.valueOf("#444444"));
        title.setWrapText(true);
        title.setFont(Font.font("System", FontWeight.BOLD, 16.0));

        Label cost = new Label(Integer.toString((i + 1) * 132));
        cost.setAlignment(Pos.CENTER);
        cost.setTextFill(Paint.valueOf("#444444"));
        cost.setWrapText(true);
        cost.setFont(Font.font("System", FontWeight.BOLD, 16.0));

        Pane vDivider = new Pane();
        Pane hDivider = new Pane();
        VBox.setVgrow(vDivider, Priority.ALWAYS);
        HBox.setHgrow(hDivider, Priority.SOMETIMES);

        HBox bottom = new HBox();
        bottom.setAlignment(Pos.CENTER);
        bottom.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        VBox costContainer = new VBox();
        costContainer.setAlignment(Pos.CENTER);

        costContainer.getChildren().addAll(cost);
        bottom.getChildren().addAll(costContainer, hDivider, add);
        container.getChildren().addAll(title, vDivider, bottom);
        container.setBackground(new Background(backgroundImage));

        return container;
    }

}
