package com.ltrsoft.ltrjob.CoursesFragment;



import java.util.ArrayList;

public class Courses_data_class {
    String al_id, al_name, al_duration, al_coursetype;

    public Courses_data_class(String al_id, String al_name, String al_duration, String al_coursetype) {
        this.al_id = al_id;
        this.al_name = al_name;
        this.al_duration = al_duration;
        this.al_coursetype = al_coursetype;
    }

    public Courses_data_class() {

    }

    public String getAl_id() {
        return al_id;
    }

    public void setAl_id(String al_id) {
        this.al_id = al_id;
    }

    public String getAl_name() {
        return al_name;
    }

    public void setAl_name(String al_name) {
        this.al_name = al_name;
    }

    public String getAl_duration() {
        return al_duration;
    }

    public void setAl_duration(String al_duration) {
        this.al_duration = al_duration;
    }

    public String getAl_coursetype() {
        return al_coursetype;
    }

    public void setAl_coursetype(String al_coursetype) {
        this.al_coursetype = al_coursetype;
    }
}