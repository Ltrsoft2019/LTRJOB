package com.ltrsoft.ltrjob.Classes;

public class User_Course_Class {
    String course_name,course_duration,course_description,fees,course_image,course_feature;

    public User_Course_Class(String course_name, String course_duration, String course_description, String course_image) {
        this.course_name = course_name;
        this.course_duration = course_duration;
        this.course_description = course_description;
        this.course_image = course_image;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_duration() {
        return course_duration;
    }

    public void setCourse_duration(String course_duration) {
        this.course_duration = course_duration;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getCourse_image() {
        return course_image;
    }

    public void setCourse_image(String course_image) {
        this.course_image = course_image;
    }

    public String getCourse_feature() {
        return course_feature;
    }

    public void setCourse_feature(String course_feature) {
        this.course_feature = course_feature;
    }
}
