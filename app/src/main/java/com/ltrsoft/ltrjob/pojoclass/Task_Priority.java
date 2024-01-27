package com.ltrsoft.ltrjob.pojoclass;

public class Task_Priority {

    private int task_priority_id;
    private String task_priority_name;

    public Task_Priority(int task_priority_id, String task_priority_name) {
        this.task_priority_id = task_priority_id;
        this.task_priority_name = task_priority_name;
    }

    public int getTask_priority_id() {
        return task_priority_id;
    }

    public void setTask_priority_id(int task_priority_id) {
        this.task_priority_id = task_priority_id;
    }

    public String getTask_priority_name() {
        return task_priority_name;
    }

    public void setTask_priority_name(String task_priority_name) {
        this.task_priority_name = task_priority_name;
    }
}
