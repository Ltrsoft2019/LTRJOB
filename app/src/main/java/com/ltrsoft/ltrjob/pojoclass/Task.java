package com.ltrsoft.ltrjob.pojoclass;

public class Task {

    private int task_id,id,status_id,priority_id,project_id;
    private String task_name,task_description,task_assingned_to,task_start_date,task_end_date;

    public Task(int task_id, int id, int status_id, int priority_id, int project_id, String task_name, String task_description, String task_assingned_to, String task_start_date, String task_end_date) {
        this.task_id = task_id;
        this.id = id;
        this.status_id = status_id;
        this.priority_id = priority_id;
        this.project_id = project_id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_assingned_to = task_assingned_to;
        this.task_start_date = task_start_date;
        this.task_end_date = task_end_date;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(int priority_id) {
        this.priority_id = priority_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_assingned_to() {
        return task_assingned_to;
    }

    public void setTask_assingned_to(String task_assingned_to) {
        this.task_assingned_to = task_assingned_to;
    }

    public String getTask_start_date() {
        return task_start_date;
    }

    public void setTask_start_date(String task_start_date) {
        this.task_start_date = task_start_date;
    }

    public String getTask_end_date() {
        return task_end_date;
    }

    public void setTask_end_date(String task_end_date) {
        this.task_end_date = task_end_date;
    }
}
