package com.example.gpa_calculator_builder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class HomeController {

    @FXML
    private void startGPA(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("input_course_details.fxml"));
        Scene scene = new Scene(loader.load());
        Node n = (Node) event.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.setScene(scene);
    }
}
