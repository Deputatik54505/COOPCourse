package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.entities.user.User;
import org.example.ui.models.SceneSwitch;

public class AuthMainPage {

    private Buyer currBuyer;

    private Seller currSeller;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Group home;

    @FXML
    private TilePane listOfProducts;

    @FXML
    private VBox listOfCategories;

    @FXML
    private Button userAccount;

    @FXML
    private Button userBasket;

    @FXML
    private TextField userSearch;

    @FXML
    private Font x1;

    private final Scanner scanner = new Scanner(System.in);

    @FXML
    void initialize() {
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'main_page.fxml'.";
        assert listOfProducts != null : "fx:id=\"listOfProducts\" was not injected: check your FXML file 'main_page.fxml'.";
        assert userAccount != null : "fx:id=\"userAccount\" was not injected: check your FXML file 'auth_main_page.fxml'.";
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'auth_main_page.fxml'.";
        assert listOfCategories != null : "fx:id=\"listOfCategories\" was not injected: check your FXML file 'main_page.fxml'.";
        assert userSearch != null : "fx:id=\"userSearch\" was not injected: check your FXML file 'main_page.fxml'.";
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'main_page.fxml'.";

        TitledPane root = new TitledPane();

        this.listOfCategories.getChildren().addAll(this.loadCategories(root));

        BackgroundImage addToCart = new BackgroundImage(
                new Image("/assets/image/icons/add-to-cart.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

        for (int i = 0; i < 20; i++) {
            VBox product = this.loadProduct(i, addToCart);
            this.listOfProducts.getChildren().add(product);
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
                    } else if (currSeller.isExist()) {
                        authMainPage.initSeller(currSeller);
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
                    } else if (currSeller.isExist()) {
                        basket.initSeller(currSeller);
                    }

                    Stage primaryStage = (Stage) userBasket.getScene().getWindow();
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.userAccount.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO check user's status (buyer or seller)
                try {
                    FXMLLoader loader = new FXMLLoader();
                    if (currBuyer.isExist()) {
                        loader.setLocation(getClass().getResource("/fxml/buyer_acc_data.fxml"));
                        Parent root = loader.load();
                        Scene newScene = new Scene(root);

                        BuyerData buyerData = loader.getController();
                        buyerData.initBuyer(currBuyer);

                        Stage primaryStage = (Stage) home.getScene().getWindow();
                        primaryStage.setScene(newScene);
                        primaryStage.show();
                    } else if (currSeller.isExist()) {
                        loader.setLocation(getClass().getResource("/fxml/seller_acc_data.fxml"));
                        Parent root = loader.load();
                        Scene newScene = new Scene(root);

                        SellerData sellerData = loader.getController();
                        sellerData.initSeller(currSeller);

                        Stage primaryStage = (Stage) userAccount.getScene().getWindow();
                        primaryStage.setScene(newScene);
                        primaryStage.show();
                    }
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

    }

    public void initBuyer(Buyer buyer) {
        this.currBuyer = buyer;
        this.currSeller = new Seller(new User("", "", "None"));
    }

    public void initSeller(Seller seller) {
        this.currBuyer = new Buyer(new User("", "", "None"));
        this.currSeller = seller;
    }

    public VBox loadProduct(int i, BackgroundImage addToCart) {
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

    public Accordion loadCategories(TitledPane parent) {
        Accordion accordion = new Accordion();
        parent.setContent(accordion);
        int k = 0;
        if (k != 0) {
            for (int i = 0; i < k; i++) {
                TitledPane container = new TitledPane();
                container.setText(parent.getText() + i + ".");
                accordion.getPanes().add(container);
                loadCategories(container);
            }
        } else {
            TitledPane container = new TitledPane();
            container.setText(parent.getText() + "leaf");
            accordion.getPanes().add(container);
        }
        return accordion;
    }

}


