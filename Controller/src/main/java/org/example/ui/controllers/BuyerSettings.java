package org.example.ui.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.entities.buyer.Buyer;
import org.example.entities.seller.Seller;
import org.example.entities.user.User;
import org.example.ui.models.*;
import org.example.validation.passport.Passport;
import org.example.validation.userdata.Data;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuyerSettings {

    private final Buyer currBuyer;

    private final Stage primaryStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button basketFavourites;

    @FXML
    private Group home;

    @FXML
    private DatePicker newDateBirth;

    @FXML
    private PasswordField newName;

    @FXML
    private PasswordField newSurname;

    @FXML
    private PasswordField userPassword;

    @FXML
    private PasswordField userPassword1;

    @FXML
    private Button confirmData;

    @FXML
    private Button confirmPassport;

    @FXML
    private PasswordField newCode;

    @FXML
    private PasswordField newNumber;

    @FXML
    private PasswordField newPublisher;

    @FXML
    private PasswordField newSeries;

    @FXML
    private Circle userAvatar;

    @FXML
    private Button userBasket;

    @FXML
    private Button userData;

    @FXML
    private Button userLogOut;

    public BuyerSettings(Buyer buyer, Stage stage) {
        this.currBuyer = buyer;
        this.primaryStage = stage;
    }

    @FXML
    void initialize() {
        assert confirmPassport != null : "fx:id=\"confirmPassport\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert confirmData != null : "fx:id=\"confirmData\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newDateBirth != null : "fx:id=\"newDateBirth\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newName != null : "fx:id=\"newName\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newSurname != null : "fx:id=\"newSurname\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userPassword != null : "fx:id=\"userPassword\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newCode != null : "fx:id=\"newCode\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newNumber != null : "fx:id=\"newNumber\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newPublisher != null : "fx:id=\"newPublisher\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert newSeries != null : "fx:id=\"newSeries\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userPassword1 != null : "fx:id=\"userPassword1\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert basketFavourites != null : "fx:id=\"basketFavourites\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert home != null : "fx:id=\"home\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userAvatar != null : "fx:id=\"userAvatar\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userBasket != null : "fx:id=\"userBasket\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userData != null : "fx:id=\"userData\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";
        assert userLogOut != null : "fx:id=\"userLogOut\" was not injected: check your FXML file 'buyer_acc_settings.fxml'.";

        this.home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new AuthMainSwitch(
                            currBuyer,
                            new Seller(new User("", "", "None")))
                            .changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userBasket.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BasketSwitch(
                            currBuyer,
                            new Seller(new User("", "", "None")))
                            .changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userData.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BuyerDataSwitch(currBuyer).changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.basketFavourites.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new BuyerFavouritesSwitch(currBuyer).changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.userLogOut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new NotAuthMainSwitch().changeScene(primaryStage);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        });

        this.confirmData.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    currBuyer.user().isEqual(userPassword.getText());
                    System.out.println(userPassword.getText());
                    new Data(
                            newName.getText(),
                            newSurname.getText(),
                            newSurname.getText()
                    ).selfValidation();

                    //TODO insert this info into DB
                    System.out.println(newName.getText());
                    System.out.println(newSurname.getText());
                    System.out.println(newDateBirth.getValue().toString());
                } catch (Exception e) {
                    System.out.println(e.toString());
                } finally {
                    userPassword.clear();
                    newName.clear();
                    newSurname.clear();
                    newDateBirth.getEditor().clear();
                }
            }
        });

        this.confirmPassport.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    currBuyer.user().isEqual(userPassword1.getText());
                    System.out.println(userPassword1.getText());
                    new Passport(
                            newSeries.getText(),
                            newNumber.getText(),
                            newPublisher.getText(),
                            newCode.getText()
                    ).selfValidation();

                    //TODO insert this into DB
                    System.out.println(newSeries.getText());
                    System.out.println(newNumber.getText());
                    System.out.println(newPublisher.getText());
                    System.out.println(newCode.getText());
                } catch (Exception e) {
                    System.out.println(e.toString());
                } finally {
                    userPassword1.clear();
                    newSeries.clear();
                    newNumber.clear();
                    newPublisher.clear();
                    newCode.clear();
                }
            }
        });
    }
}
