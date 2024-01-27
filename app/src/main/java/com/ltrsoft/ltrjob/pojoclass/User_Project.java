package com.ltrsoft.ltrjob.pojoclass;

public class User_Project {

    private int id,user_project_id,user_id,project_id;

    public User_Project(int id, int user_project_id, int user_id, int project_id) {
        this.id = id;
        this.user_project_id = user_project_id;
        this.user_id = user_id;
        this.project_id = project_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_project_id() {
        return user_project_id;
    }

    public void setUser_project_id(int user_project_id) {
        this.user_project_id = user_project_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
