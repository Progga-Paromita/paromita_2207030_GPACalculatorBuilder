package com.example.gpa_calculator_builder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class InputCourseController {
    @FXML private TextField courseNameField;
    @FXML private TextField courseCodeField;
    @FXML private TextField courseCreditField;
    @FXML private TextField teacher1Field;
    @FXML private TextField teacher2Field;
    @FXML private TextField gradeField;
    @FXML private Button calculateGPAButton;
    @FXML private TableView<Course> previewTable;

    private final ObservableList<Course> courseList = FXCollections.observableArrayList();
    private int totalCreditsEntered = 0;
    private final int predefinedTotalCredits = 12;

    @FXML
    private void initialize() {
        previewTable.setItems(courseList);
        calculateGPAButton.setDisable(true);
    }

    @FXML
    private void addCourse(ActionEvent event) {
        String name = courseNameField.getText().trim();
        String code = courseCodeField.getText().trim();
        String creditStr = courseCreditField.getText().trim();
        String teacher1 = teacher1Field.getText().trim();
        String teacher2 = teacher2Field.getText().trim();
        String grade = gradeField.getText().trim().toUpperCase();

        int credit;
        credit = Integer.parseInt(creditStr);
        Course course = new Course(name, code, credit, teacher1, teacher2, grade);
        courseList.add(course);
        totalCreditsEntered += credit;
        clearFields();

        if (totalCreditsEntered >= predefinedTotalCredits) {
            calculateGPAButton.setDisable(false);
        }
    }
    private void clearFields() {
        courseNameField.clear();
        courseCodeField.clear();
        courseCreditField.clear();
        teacher1Field.clear();
        teacher2Field.clear();
        gradeField.clear();
    }

    @FXML
    private void calculateGPA(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("list_of_all_course.fxml"));
        Scene scene = new Scene(loader.load());
        ListCourseController controller = loader.getController();
        controller.setCourseList(courseList);
        controller.calculateAndSetGPA();
        Node n = (Node) event.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.setScene(scene);
    }

    public ObservableList<Course> getCourseList() {
        return courseList;
    }
}
