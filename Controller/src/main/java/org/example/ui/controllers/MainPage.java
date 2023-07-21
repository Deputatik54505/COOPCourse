package org.example.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.ui.models.SceneSwitch;

public class MainPage {

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

    private final Scanner scanner = new Scanner(System.in);

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

        this.listOfCategories.getChildren().addAll(this.addCategories(root));

        for (int i = 0; i < 20; i++) {
            VBox product = this.addProduct(i);
            this.listOfProducts.getChildren().add(product);
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

        this.userLogIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/log_in_form.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.userSignIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new SceneSwitch().changeScene(event, "/fxml/sign_in_form.fxml");
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

    }

    public VBox addProduct(int i) {
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image("/assets/image/logo.jpg"), //BD
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );

        Image image = new Image("/assets/image/icons/add-to-cart.png");
        ImageView addToCart = new ImageView(image);
        addToCart.setCursor(Cursor.HAND);
        addToCart.setOnMouseClicked(new EventHandler<MouseEvent>() {
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
        bottom.getChildren().addAll(costContainer, hDivider, addToCart);
        container.getChildren().addAll(title, vDivider, bottom);
        container.setBackground(new Background(backgroundImage));

        return container;
    }

    public Accordion addCategories(TitledPane parent) {
        Accordion accordion = new Accordion();
        parent.setContent(accordion);
        int k = Integer.parseInt(scanner.nextLine());
        if (k != 0) {
            for (int i = 0; i < k; i++) {
                TitledPane container = new TitledPane();
                container.setText(parent.getText() + i + ".");
                accordion.getPanes().add(container);
                addCategories(container);
            }
        } else {
            TitledPane container = new TitledPane();
            container.setText(parent.getText() + "leaf");
            accordion.getPanes().add(container);
        }
        return accordion;
    }

}


