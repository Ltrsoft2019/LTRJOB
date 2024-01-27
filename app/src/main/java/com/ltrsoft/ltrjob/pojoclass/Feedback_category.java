package com.ltrsoft.ltrjob.pojoclass;

public class Feedback_category {
    private int id,feedback_category_id;
    private String feedback_category_name;

    public Feedback_category(int id, int feedback_category_id, String feedback_category_name) {
        this.id = id;
        this.feedback_category_id = feedback_category_id;
        this.feedback_category_name = feedback_category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFeedback_category_id() {
        return feedback_category_id;
    }

    public void setFeedback_category_id(int feedback_category_id) {
        this.feedback_category_id = feedback_category_id;
    }

    public String getFeedback_category_name() {
        return feedback_category_name;
    }

    public void setFeedback_category_name(String feedback_category_name) {
        this.feedback_category_name = feedback_category_name;
    }
}
