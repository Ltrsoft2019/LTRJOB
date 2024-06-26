package com.ltrsoft.ltrjob.pojoclass;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;

public class Feedback {
    private int id,feedback_id,feedback_category_id;
    private String feedback_description,user_id;

    public Feedback(int id, int feedback_id, int feedback_category_id, String user_id, String feedback_description) {
        this.id = id;
        this.feedback_id = feedback_id;
        this.feedback_category_id = feedback_category_id;
        this.user_id = user_id;
        this.feedback_description = feedback_description;
    }

    public Feedback(String feedbackDescription) {
        this.feedback_description = feedback_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public int getFeedback_category_id() {
        return feedback_category_id;
    }

    public void setFeedback_category_id(int feedback_category_id) {
        this.feedback_category_id = feedback_category_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFeedback_description() {
        return feedback_description;
    }

    public void setFeedback_description(String feedback_description) {
        this.feedback_description = feedback_description;
    }


}
