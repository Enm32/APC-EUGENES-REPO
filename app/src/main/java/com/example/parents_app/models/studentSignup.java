package com.example.parents_app.models;

public class studentSignup {
    private String student_name;
    private String parent_name;
    private String studentGrade;
    private String parentPhone;
    private String emailAddress;
    private String notif_token;


    public studentSignup() {
    }

    public studentSignup(String student_name, String parent_name, String studentGrade, String parentPhone, String emailAddress, String notif_token) {
        this.student_name = student_name;
        this.parent_name = parent_name;
        this.studentGrade = studentGrade;
        this.parentPhone = parentPhone;
        this.emailAddress = emailAddress;
        this.notif_token = notif_token;
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

    public String getNotif_token() {
        return notif_token;
    }

    public void setNotif_token(String notif_token) {
        this.notif_token = notif_token;
    }
}
