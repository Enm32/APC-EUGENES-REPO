package com.example.progresscheckerforcbc.model;

public class add_rating_model {
    private String subject;
    private String topic;
    private String topic_rating;
    private String student_name;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setTopic_rating(String topic_rating) {
        this.topic_rating = topic_rating;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSubject() {
        return subject;
    }

    public String getTopic() {
        return topic;
    }

    public String getTopic_rating() {
        return topic_rating;
    }

    public String getStudent_name() {
        return student_name;
    }

    public add_rating_model() {
    }

    public add_rating_model(String subject, String topic, String topic_rating, String student_name) {
        this.subject = subject;
        this.topic = topic;
        this.topic_rating = topic_rating;
        this.student_name = student_name;
    }


}
