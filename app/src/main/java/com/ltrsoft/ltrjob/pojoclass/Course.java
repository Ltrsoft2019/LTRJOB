package com.ltrsoft.ltrjob.pojoclass;

public class Course {
    private int id,course_id;
    private String course_name,course_duration,course_description;

    public Course(int id, int course_id, String course_name, String course_duration, String course_description) {
        this.id = id;
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_duration = course_duration;
        this.course_description = course_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
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
}
