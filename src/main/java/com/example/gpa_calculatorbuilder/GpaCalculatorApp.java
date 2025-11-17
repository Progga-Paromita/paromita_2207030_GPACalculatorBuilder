package com.example.gpa_calculator_builder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GpaCalculatorApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home_screen.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("GPA Calculator Builder");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
