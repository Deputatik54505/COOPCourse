package org.example.ui.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.example.entities.product.Product;
import org.example.entities.product.ProductCategory;
import org.example.ui.models.LogInSwitch;
import org.example.ui.models.NotAuthMainSwitch;
import org.example.ui.models.SignInSwitch;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPage {
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
    private Button userLogIn;
    @FXML
    private TextField userSearch;
    @FXML
    private Button userSignIn;
    @FXML
    private Font x1;

    public MainPage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    void initialize() {
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'main_page.fxml'.";
        assert listOfProducts != null : "fx:id=\"listOfProducts\" was not injected: check your FXML file 'main_page.fxml'.";
        assert listOfCategories != null : "fx:id=\"listOfCategories\" was not injected: check your FXML file 'main_page.fxml'.";
        assert userLogIn != null : "fx:id=\"userLogIn\" was not injected: check your FXML file 'main_page.fxml'.";
        assert userSearch != null : "fx:id=\"userSearch\" was not injected: check your FXML file 'main_page.fxml'.";
        assert userSignIn != null : "fx:id=\"userSignIn\" was not injected: check your FXML file 'main_page.fxml'.";
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'main_page.fxml'.";

        TitledPane root = new TitledPane();
        ProductCategory rootCategory = new ProductCategory(1);
        rootCategory.load();
        this.listOfCategories.getChildren().addAll(this.loadCategories(root, rootCategory));

        BackgroundImage addToCart = new BackgroundImage(
                new Image("/assets/image/icons/add-to-cart.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

        for (var product : rootCategory.getProducts()) {
            VBox productVBox = this.loadProduct(product, addToCart);
            this.listOfProducts.getChildren().add(productVBox);
        }

        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new NotAuthMainSwitch().changeScene(primaryStage);
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

        this.userLogIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new LogInSwitch().changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.userSignIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SignInSwitch().changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
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

    public Accordion loadCategories(TitledPane parent, ProductCategory category) {
        Accordion accordion = new Accordion();
        parent.setContent(accordion);
        var k = category.hierarchy().child();
        if (k.size() != 0) {
            for (var subcategory : k) {
                TitledPane container = new TitledPane();
                container.setText(parent.getText() + subcategory.specifications().name() + ".");
                accordion.getPanes().add(container);
                loadCategories(container, subcategory);
            }
        } else {
            TitledPane container = new TitledPane();
            container.setText(parent.getText() + category.specifications().name());
            accordion.getPanes().add(container);
        }
        return accordion;
    }

}


