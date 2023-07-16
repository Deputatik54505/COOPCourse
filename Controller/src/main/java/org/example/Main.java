package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.user.User;
import org.example.entities.users.Users;
import org.example.forms.data.FData;
import org.example.forms.log.FLogIn;
import org.example.forms.passport.FPassport;
import org.example.forms.sign.FSignIn;

import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/main_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 700);

        primaryStage.setTitle("Shop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();

//        //Form: add passport
//        FPassport fPassport = new FPassport(particularUser);
//        fPassport.verify(scanner);
//
//        //Form: add user data (name, surname, date of birth)
//        FData fData = new FData(particularUser);
//        fData.verify(scanner);
//
//        fLogIn.verify(scanner);
    }
}