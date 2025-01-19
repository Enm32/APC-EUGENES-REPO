package com.example.parents_app.models;

public class ratings {
    private String topic ;
    private String rating;
    public ratings() {
    }
    public ratings(String topic, String rating) {
        this.topic = topic;
        this.rating = rating;
    }



    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
