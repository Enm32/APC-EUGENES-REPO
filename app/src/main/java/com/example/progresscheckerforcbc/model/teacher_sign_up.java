package com.example.progresscheckerforcbc.model;

import java.util.List;

public class teacher_sign_up {
    private String full_name;
    private List<String> t_subjects;
    private String phone;


    public String getFull_name() {
        return full_name;
    }

    public teacher_sign_up(String full_name, List<String> t_subjects, String phone) {
        this.full_name = full_name;
        this.t_subjects = t_subjects;
        this.phone = phone;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public List<String> getT_subjects() {
        return t_subjects;
    }

    public void setT_subjects(List<String> t_subjects) {
        this.t_subjects = t_subjects;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public teacher_sign_up() {
    }
}
