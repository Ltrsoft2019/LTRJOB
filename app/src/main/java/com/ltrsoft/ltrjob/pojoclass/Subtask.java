package com.ltrsoft.ltrjob.pojoclass;

public class Subtask {
    private int id,subtask_assingned_to_user_id,status_id,priority_id,subtask_project_id,task_id;
    private String subtask_name,subtask_description,subtask_start_date,subtask_end_date;

    public Subtask(int id, int subtask_assingned_to_user_id, int status_id, int priority_id, int subtask_project_id, int task_id, String subtask_name, String subtask_description, String subtask_start_date, String subtask_end_date) {
        this.id = id;
        this.subtask_assingned_to_user_id = subtask_assingned_to_user_id;
        this.status_id = status_id;
        this.priority_id = priority_id;
        this.subtask_project_id = subtask_project_id;
        this.task_id = task_id;
        this.subtask_name = subtask_name;
        this.subtask_description = subtask_description;
        this.subtask_start_date = subtask_start_date;
        this.subtask_end_date = subtask_end_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubtask_assingned_to_user_id() {
        return subtask_assingned_to_user_id;
    }

    public void setSubtask_assingned_to_user_id(int subtask_assingned_to_user_id) {
        this.subtask_assingned_to_user_id = subtask_assingned_to_user_id;
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

    public int getSubtask_project_id() {
        return subtask_project_id;
    }

    public void setSubtask_project_id(int subtask_project_id) {
        this.subtask_project_id = subtask_project_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getSubtask_name() {
        return subtask_name;
    }

    public void setSubtask_name(String subtask_name) {
        this.subtask_name = subtask_name;
    }

    public String getSubtask_description() {
        return subtask_description;
    }

    public void setSubtask_description(String subtask_description) {
        this.subtask_description = subtask_description;
    }

    public String getSubtask_start_date() {
        return subtask_start_date;
    }

    public void setSubtask_start_date(String subtask_start_date) {
        this.subtask_start_date = subtask_start_date;
    }

    public String getSubtask_end_date() {
        return subtask_end_date;
    }

    public void setSubtask_end_date(String subtask_end_date) {
        this.subtask_end_date = subtask_end_date;
    }
}
