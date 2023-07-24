package org.example.ui.controllers;

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
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.product.Product;
import org.example.entities.product.ProductCategory;
import org.example.entities.seller.Seller;
import org.example.ui.models.AuthMainSwitch;
import org.example.ui.models.BasketSwitch;
import org.example.ui.models.BuyerDataSwitch;
import org.example.ui.models.SellerDataSwitch;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AuthMainPage {
    private final Buyer currBuyer;
    private final Seller currSeller;

    private final Stage primaryStage;
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

    public AuthMainPage(Buyer buyer, Seller seller, Stage stage) {
        this.currBuyer = buyer;
        this.currSeller = seller;
        this.primaryStage = stage;
    }

    @FXML
    void initialize() {
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'main_page.fxml'.";
        assert listOfProducts != null : "fx:id=\"listOfProducts\" was not injected: check your FXML file 'main_page.fxml'.";
        assert userAccount != null : "fx:id=\"userAccount\" was not injected: check your FXML file 'auth_main_page.fxml'.";
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'auth_main_page.fxml'.";
        assert listOfCategories != null : "fx:id=\"listOfCategories\" was not injected: check your FXML file 'main_page.fxml'.";
        assert userSearch != null : "fx:id=\"userSearch\" was not injected: check your FXML file 'main_page.fxml'.";
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'main_page.fxml'.";

        //TODO check that the connection to the DB is correct
//        IProductCategory rootCategory = new ProductCategory(1);
//        TitledPane root = new TitledPane();
//        this.listOfCategories.getChildren().addAll(this.loadCategories(root, rootCategory));

        BackgroundImage addToCart = new BackgroundImage(
                new Image("/assets/image/icons/add-to-cart.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

        //TODO check that the connection to the DB is correct
//        for (var product : rootCategory.getProducts()) {
//            VBox productVBox = this.loadProduct(product, addToCart);
//            this.listOfProducts.getChildren().add(productVBox);
//        }

        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new AuthMainSwitch(currBuyer, currSeller).changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userBasket.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BasketSwitch(currBuyer, currSeller).changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.userAccount.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    if (currBuyer.user.isBuyer()) {
                        new BuyerDataSwitch(currBuyer).changeScene(primaryStage);
                    } else if (currSeller.user.isSeller()) {
                        new SellerDataSwitch(currSeller).changeScene(primaryStage);
                    }
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userSearch.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    //TODO implement search on the main page
                }
            }
        });

    }

    public VBox loadProduct(Product product, BackgroundImage addToCart) {
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
                if (currBuyer.user.isBuyer())
                    currBuyer.shoppingCart.addPurchase(product);

                // I think we should discuss if we have to add shopping cart to seller
                //TODO add to Buyer's or Seller's basket (check the type of the user calling isExist())
            }
        });

        VBox container = new VBox();
        TilePane.setMargin(container, new Insets(4));

        String productName = product.data().represent().get(0);
        String productPrice = product.data().represent().get(2);

        Label title = new Label(productName);
        title.setTextFill(Paint.valueOf("#444444"));
        title.setWrapText(true);
        title.setFont(Font.font("System", FontWeight.BOLD, 16.0));

        Label cost = new Label(productPrice);
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

    public Accordion loadCategories(TitledPane parent, ProductCategory productCategory) {
        Accordion accordion = new Accordion();
        parent.setContent(accordion);

        var k = productCategory.hierarchy().child();
        if (k.size() != 0) {
            for (var category : k) {
                TitledPane container = new TitledPane();
                container.setText(parent.getText() + category.specifications().name() + ".");
                accordion.getPanes().add(container);
                loadCategories(container, category);
            }
        } else {
            TitledPane container = new TitledPane();
            container.setText(parent.getText() + productCategory.specifications().name());
            accordion.getPanes().add(container);
        }
        return accordion;
    }

}


