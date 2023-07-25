package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.ui.controllers.MainPage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main_page.fxml"));
        loader.setController(new MainPage(primaryStage));
        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("Shop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}