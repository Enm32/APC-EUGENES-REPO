package com.example.parents_app.models;

public class student_class {
    private String studentName;
    private String student_grade;

    public student_class() {
    }

    public student_class(String studentName, String student_grade) {
        this.studentName = studentName;
        this.student_grade = student_grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudent_grade() {
        return student_grade;
    }

    public void setStudent_grade(String student_grade) {
        this.student_grade = student_grade;
    }
}
