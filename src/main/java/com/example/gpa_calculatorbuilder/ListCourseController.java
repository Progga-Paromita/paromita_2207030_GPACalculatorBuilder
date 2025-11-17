package com.example.gpa_calculator_builder;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class ListCourseController {
    @FXML private TableView<Course> courseTable;
    @FXML private TableColumn<Course, String> courseNameCol;
    @FXML private TableColumn<Course, String> courseCodeCol;
    @FXML private TableColumn<Course, Number> creditCol;
    @FXML private TableColumn<Course, String> gradeCol;
    @FXML private TableColumn<Course, String> teacher1Col;
    @FXML private TableColumn<Course, String> teacher2Col;
    @FXML private Label totalGpaLabel;
    @FXML private Label totalCreditsLabel;
    private ObservableList<Course> courseList;
    @FXML
    private void initialize() {
        courseNameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        courseCodeCol.setCellValueFactory(cell -> cell.getValue().codeProperty());
        creditCol.setCellValueFactory(cell -> cell.getValue().creditProperty());
        gradeCol.setCellValueFactory(cell -> cell.getValue().gradeProperty());
        teacher1Col.setCellValueFactory(cell -> cell.getValue().teacher1Property());
        teacher2Col.setCellValueFactory(cell -> cell.getValue().teacher2Property());
    }
    public void setCourseList(ObservableList<Course> list) {
        this.courseList = list;
        courseTable.setItems(courseList);
    }
    public void calculateAndSetGPA() {
        double totalPoints = 0.0;
        int totalCredits = 0;
        for (Course c : courseList) {
            int credit = c.getCredit();
            double gp = convertGradeToPoint(c.getGrade());
            totalPoints += gp * credit;
            totalCredits += credit;
        }
        double gpa = totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
        totalGpaLabel.setText(String.format("Your total GPA: %.2f", gpa));
    }
    private double convertGradeToPoint(String grade) {
        return switch (grade) {
            case "A+" -> 4.00;
            case "A"  -> 3.75;
            case "A-" -> 3.50;
            case "B" -> 3.25;
            case "C"  -> 3.00;
            case "D" -> 2.75;
            case "F" -> 2.50;
            default   -> 0.0;
        };
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("input_course_details.fxml"));
        Scene scene = new Scene(loader.load());
        InputCourseController inputController = loader.getController();
        inputController.getCourseList().clear();
        inputController.getCourseList().addAll(courseList);
        Node n = (Node) event.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.setScene(scene);
    }
}
