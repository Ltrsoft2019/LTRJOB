package com.ltrsoft.ltrjob.pojoclass;

public class Mini_Project_User {

    private int mini_project_user_id,mini_project_id,user_id,status_id;

    public Mini_Project_User(int mini_project_user_id, int mini_project_id, int user_id, int status_id) {
        this.mini_project_user_id = mini_project_user_id;
        this.mini_project_id = mini_project_id;
        this.user_id = user_id;
        this.status_id = status_id;
    }

    public int getMini_project_user_id() {
        return mini_project_user_id;
    }

    public void setMini_project_user_id(int mini_project_user_id) {
        this.mini_project_user_id = mini_project_user_id;
    }

    public int getMini_project_id() {
        return mini_project_id;
    }

    public void setMini_project_id(int mini_project_id) {
        this.mini_project_id = mini_project_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }
}
