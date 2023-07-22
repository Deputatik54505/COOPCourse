package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.entities.user.User;
import org.example.ui.models.AccountSwitch;
import org.example.ui.models.MainBasketSwitch;
import org.example.ui.models.HomeSwitch;

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

        //TODO load all categories from DB: addAll(this.loadCategories(root, someCategory))
        TitledPane root = new TitledPane();
        this.listOfCategories.getChildren().addAll(this.loadCategories(root));

        BackgroundImage addToCart = new BackgroundImage(
                new Image("/assets/image/icons/add-to-cart.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

        //TODO load all products through DB, call loadProduct(someProduct, addToCart)
        for (int i = 0; i < 20; i++) {
            VBox product = this.loadProduct(i, addToCart);
            this.listOfProducts.getChildren().add(product);
        }

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

        this.userBasket.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new MainBasketSwitch().changeScene(currBuyer, currSeller, event);
                } catch (IOException e) {
                    throw new RuntimeException(e);
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

        this.userSearch.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //TODO implement search by pressing ENTER in the basket
                if (event.getCode().equals(KeyCode.ENTER)) {

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
                //TODO load image from DB
                new Image("/assets/image/logo.jpg"),
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
                //TODO add to Buyer's or Seller's shopping cart (check the type of the user calling isExist())
            }
        });

        VBox container = new VBox();
        TilePane.setMargin(container, new Insets(4));

        //TODO load title from DB
        Label title = new Label("Title");
        title.setTextFill(Paint.valueOf("#444444"));
        title.setWrapText(true);
        title.setFont(Font.font("System", FontWeight.BOLD, 16.0));

        //TODO load cost from DB, put it inside Integer.toString(...)
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
        //TODO load the number of directed children of particular category: k = cat.loadDirectChild(...)
        int k = 0;
        if (k != 0) {
            for (int i = 0; i < k; i++) {
                TitledPane container = new TitledPane();
                //TODO load and set text for the non-leaf category inside setText(...)
                container.setText(parent.getText() + i + ".");
                accordion.getPanes().add(container);
                loadCategories(container);
            }
        } else {
            TitledPane container = new TitledPane();
            //TODO load and set text for the leaf category inside setText(...)
            container.setText(parent.getText() + "leaf");
            accordion.getPanes().add(container);
        }
        return accordion;
    }

}


