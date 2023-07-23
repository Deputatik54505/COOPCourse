package org.example.ui.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.entities.buyer.Buyer;
import org.example.entities.product.Product;
import org.example.entities.seller.Seller;
import org.example.entities.user.User;
import org.example.ui.models.AccountSwitch;
import org.example.ui.models.HomeSwitch;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Basket {

    private Buyer currBuyer;

    private Seller currSeller;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button userAccount;

    @FXML
    private TextField UserSearch;

    @FXML
    private Button buyPurchase;

    @FXML
    private TextField cardNumber;

    @FXML
    private Group home;

    @FXML
    private TilePane listOfProducts;

    @FXML
    private Label numPurchases;

    @FXML
    private TextField pointDelivery;

    @FXML
    private Label subtotalCost;

    @FXML
    private Font x1;

    @FXML
    void initialize() {
        assert userAccount != null : "fx:id=\"userAccount\" was not injected: check your FXML file 'shopping_cart.fxml'.";
        assert UserSearch != null : "fx:id=\"UserSearch\" was not injected: check your FXML file 'shopping_cart.fxml'.";
        assert buyPurchase != null : "fx:id=\"buyPurchase\" was not injected: check your FXML file 'shopping_cart.fxml'.";
        assert cardNumber != null : "fx:id=\"cardNumber\" was not injected: check your FXML file 'shopping_cart.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'shopping_cart.fxml'.";
        assert listOfProducts != null : "fx:id=\"listOfProducts\" was not injected: check your FXML file 'shopping_cart.fxml'.";
        assert numPurchases != null : "fx:id=\"numPurchases\" was not injected: check your FXML file 'shopping_cart.fxml'.";
        assert pointDelivery != null : "fx:id=\"pointDelivery\" was not injected: check your FXML file 'shopping_cart.fxml'.";
        assert subtotalCost != null : "fx:id=\"subtotalCost\" was not injected: check your FXML file 'shopping_cart.fxml'.";
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'shopping_cart.fxml'.";

        BackgroundImage trashCan = new BackgroundImage(
                new Image("/assets/image/icons/trash.png"), //BD
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

// todo: add purchases in the list
        ArrayList<Product> purchases = new ArrayList<>();
        for (var product : purchases) {
            HBox hBox = loadProduct(product, trashCan);
            this.listOfProducts.getChildren().add(hBox);
        }

        this.numPurchases.setText(String.valueOf(purchases.size()));

        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new HomeSwitch().changeScene(currBuyer, currSeller, event);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userAccount.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new AccountSwitch().changeScene(currBuyer, currSeller, event);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.UserSearch.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //TODO implement search by pressing ENTER in the basket
                if (event.getCode().equals(KeyCode.ENTER)) {

                }
            }
        });

        this.buyPurchase.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO validate place and card number, remove from basket DB
            }
        });

        this.listOfProducts.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (listOfProducts.getWidth() <= 600) {
                    listOfProducts.setPrefTileWidth(listOfProducts.getWidth() - 100);
                }
            }
        });
    }

    public HBox loadProduct(Product product, BackgroundImage trashCan) {
        BackgroundImage backgroundImage = new BackgroundImage(
                //TODO load image from DB
                new Image("/assets/image/logo.jpg"), //BD
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );

        HBox hBox = new HBox();

        Pane pane1 = new Pane();
        VBox.setVgrow(pane1, Priority.ALWAYS);
        Pane pane2 = new Pane();
        VBox.setVgrow(pane2, Priority.ALWAYS);
        Pane pane3 = new Pane();
        VBox.setVgrow(pane3, Priority.ALWAYS);


        var productData = product.data.represent();

        String productName = productData.get(0);
        String productDescription = productData.get(1);
        String productPrice = productData.get(2);


        Label title = new Label(productName);
        title.setPadding(new Insets(16.0, 0.0, 0.0, 16.0));
        title.setFont(Font.font("System", FontWeight.BOLD, 16.0));

        Label desc = new Label(productDescription);
        desc.setPadding(new Insets(0.0, 0.0, 12.0, 12.0));
        desc.setFont(Font.font(14.0));

        Label cost = new Label(productPrice);
        cost.setPadding(new Insets(0.0, 8.0, 8.0, 0.0));
        cost.setFont(Font.font(16.0));

        CheckBox include = new CheckBox();
        VBox.setMargin(include, new Insets(8.0, 8.0, 0.0, 0.0));
        include.setMnemonicParsing(false);
        include.setSelected(false);
        include.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (include.isSelected()) {
                    subtotalCost.setText(Integer.toString(
                            Integer.parseInt(subtotalCost.getText()) +
                                    Integer.parseInt(cost.getText())
                    ));
                } else {
                    subtotalCost.setText(Integer.toString(
                            Integer.parseInt(subtotalCost.getText()) -
                                    Integer.parseInt(cost.getText())
                    ));
                }
            }
        });

        Button button = new Button();
        button.setBackground(new Background(trashCan));
        button.setCursor(Cursor.HAND);
        button.setPrefSize(32.0, 32.0);
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO delete from user's shopping cart
                listOfProducts.getChildren().remove(hBox);
                if (include.isSelected()) {
                    subtotalCost.setText(Integer.toString(
                            Integer.parseInt(subtotalCost.getText()) -
                                    Integer.parseInt(cost.getText())
                    ));
                }
            }
        });

        VBox vBoxL = new VBox(title, pane1, desc);
        HBox.setHgrow(vBoxL, Priority.ALWAYS);

        VBox vBoxR = new VBox(include, pane2, button, pane3, cost);
        vBoxR.setAlignment(Pos.TOP_RIGHT);
        vBoxR.setMaxWidth(Region.USE_PREF_SIZE);

        hBox.getChildren().addAll(vBoxL, vBoxR);
        TilePane.setMargin(hBox, new Insets(4));
        hBox.setBackground(new Background(backgroundImage));

        return hBox;
    }

    public void initBuyer(Buyer buyer) {
        this.currBuyer = buyer;
        this.currSeller = new Seller(new User("", "", "None"));
    }

    public void initSeller(Seller seller) {
        this.currBuyer = new Buyer(new User("", "", "None"));
        this.currSeller = seller;
    }

}
