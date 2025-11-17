package com.example.gpa_calculator_builder;

import javafx.beans.property.*;

public class Course {
    final StringProperty name = new SimpleStringProperty();
    final StringProperty code = new SimpleStringProperty();
    final IntegerProperty credit = new SimpleIntegerProperty();
    final StringProperty teacher1 = new SimpleStringProperty();
    final StringProperty teacher2 = new SimpleStringProperty();
    final StringProperty grade = new SimpleStringProperty();

    public Course(String name, String code, int credit, String teacher1, String teacher2, String grade) {
        this.name.set(name);
        this.code.set(code);
        this.credit.set(credit);
        this.teacher1.set(teacher1);
        this.teacher2.set(teacher2);
        this.grade.set(grade);
    }

    public StringProperty nameProperty() { return name; }
    public StringProperty codeProperty() { return code; }

    public IntegerProperty creditProperty() { return credit; }
    public int getCredit() { return credit.get(); }

    public StringProperty teacher1Property() { return teacher1; }
    public StringProperty teacher2Property() { return teacher2; }

    public StringProperty gradeProperty() { return grade; }
    public String getGrade() { return grade.get(); }
}
