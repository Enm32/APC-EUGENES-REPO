package com.example.parents_app.models;

public class studentSignup {
    private String student_name;
    private String parent_name;
    private String studentGrade;
    private String parentPhone;
    private String emailAddress;

    public studentSignup() {
    }

    public studentSignup(String student_name, String parent_name, String studentGrade, String parentPhone, String emailAddress) {
        this.student_name = student_name;
        this.parent_name = parent_name;
        this.studentGrade = studentGrade;
        this.parentPhone = parentPhone;
        this.emailAddress = emailAddress;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
