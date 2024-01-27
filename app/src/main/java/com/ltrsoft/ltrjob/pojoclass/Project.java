package com.ltrsoft.ltrjob.pojoclass;

public class Project {
    private int project_id,id,user_id;
    private String project_name,project_description,project_end_date,project_start_date,project_technologies,project_category;

    public Project(int project_id, int id, int user_id, String project_name, String project_description, String project_end_date, String project_start_date, String project_technologies, String project_category) {
        this.project_id = project_id;
        this.id = id;
        this.user_id = user_id;
        this.project_name = project_name;
        this.project_description = project_description;
        this.project_end_date = project_end_date;
        this.project_start_date = project_start_date;
        this.project_technologies = project_technologies;
        this.project_category = project_category;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public String getProject_end_date() {
        return project_end_date;
    }

    public void setProject_end_date(String project_end_date) {
        this.project_end_date = project_end_date;
    }

    public String getProject_start_date() {
        return project_start_date;
    }

    public void setProject_start_date(String project_start_date) {
        this.project_start_date = project_start_date;
    }

    public String getProject_technologies() {
        return project_technologies;
    }

    public void setProject_technologies(String project_technologies) {
        this.project_technologies = project_technologies;
    }

    public String getProject_category() {
        return project_category;
    }

    public void setProject_category(String project_category) {
        this.project_category = project_category;
    }
}
