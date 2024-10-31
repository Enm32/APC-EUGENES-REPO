package com.example.progresscheckerforcbc.model;

public class rating_response {
    private String topic_name;
    private String student_rating;

    public rating_response() {
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getStudent_rating() {
        return student_rating;
    }

    public void setStudent_rating(String student_rating) {
        this.student_rating = student_rating;
    }

    public rating_response(String topic_name, String student_rating) {
        this.topic_name = topic_name;
        this.student_rating = student_rating;
    }


}
