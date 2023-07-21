package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import org.example.ui.models.SceneSwitch;

public class Cart {

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

        this.numPurchases.setText(Integer.toString(10));

        //TODO load goods from user's shopping cart
        //add products
        for (int i = 0; i < 10; i++) {
            HBox hBox = addProduct(i, trashCan);
            this.listOfProducts.getChildren().add(hBox);
        }

        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/main_page.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userAccount.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/buyer_acc_data.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.UserSearch.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {

                }
            }
        });

        this.buyPurchase.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //validate place and card number
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

    public HBox addProduct(int i, BackgroundImage trashCan) {
        BackgroundImage backgroundImage = new BackgroundImage(
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

        Label title = new Label("Title"); //BD
        title.setPadding(new Insets(16.0, 0.0, 0.0, 16.0));
        title.setFont(Font.font("System Bold", 16.0));

        Label desc = new Label("Description"); //BD
        desc.setPadding(new Insets(0.0, 0.0, 12.0, 12.0));
        desc.setFont(Font.font(14.0));

        Label cost = new Label(Integer.toString(i * 230)); //BD
        cost.setPadding(new Insets(0.0, 8.0, 8.0, 0.0));
        cost.setFont(Font.font(16.0));

        CheckBox include = new CheckBox();
        VBox.setMargin(include, new Insets(8.0, 8.0, 0.0, 0.0));
        include.setMnemonicParsing(false);
        include.setSelected(false);
        include.setId(Integer.toString(i));
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
        hBox.setId(Integer.toString(i));

        return hBox;
    }

}
