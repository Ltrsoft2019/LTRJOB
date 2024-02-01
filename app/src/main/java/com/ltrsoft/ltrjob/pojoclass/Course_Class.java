package com.ltrsoft.ltrjob.pojoclass;

public class Course_Class {
    public String course_id,course_name,course_duration,course_description,fees,course_image,course_feature,created_at;

    public Course_Class() {
    }

    public Course_Class(String course_id,String course_name, String course_duration, String course_description, String fees, String course_image, String course_feature, String created_at) {
        this.course_id=course_id;

        this.course_name = course_name;
        this.course_duration = course_duration;
        this.course_description = course_description;
        this.fees = fees;
        this.course_image = course_image;
        this.course_feature = course_feature;
        this.created_at=created_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String setCourse_id(String course_id) {
        this.course_id = course_id;
        return course_id;

    }

    public String getCourse_name() {
        return course_name;
    }

    public CharSequence setCourse_name(String course_name) {
        this.course_name = course_name;
        return course_name;
    }

    public String getCourse_duration() {
        return course_duration;
    }

    public String setCourse_duration(String course_duration) {
        this.course_duration = course_duration;
        return course_duration ;
    }

    public String getCourse_description() {
        return course_description;
    }

    public String setCourse_description(String course_description) {
        this.course_description = course_description;
        return course_description;
    }

    public String getFees() {
        return fees;
    }

    public String setFees(String fees) {
        this.fees = fees;
        return fees;

    }

    public String getCourse_image() {
        return course_image;
    }

    public String setCourse_image(String course_image) {
        this.course_image = course_image;
        return course_image;

    }

    public String getCourse_feature() {
        return course_feature;
    }

    public String setCourse_feature(String course_feature) {
        this.course_feature = course_feature;
        return course_feature;

    }

}
