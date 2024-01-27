package com.ltrsoft.ltrjob.pojoclass;

public class User_Project_Task {

    private int id,user_project_task_id,task_id,user_project_id;

    public User_Project_Task(int id, int user_project_task_id, int task_id, int user_project_id) {
        this.id = id;
        this.user_project_task_id = user_project_task_id;
        this.task_id = task_id;
        this.user_project_id = user_project_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_project_task_id() {
        return user_project_task_id;
    }

    public void setUser_project_task_id(int user_project_task_id) {
        this.user_project_task_id = user_project_task_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getUser_project_id() {
        return user_project_id;
    }

    public void setUser_project_id(int user_project_id) {
        this.user_project_id = user_project_id;
    }
}
