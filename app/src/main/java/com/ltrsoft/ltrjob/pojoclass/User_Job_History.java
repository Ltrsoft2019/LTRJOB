package com.ltrsoft.ltrjob.pojoclass;

public class User_Job_History {

    private int id,user_job_history_id,user_id,job_id;

    public User_Job_History(int id, int user_job_history_id, int user_id, int job_id) {
        this.id = id;
        this.user_job_history_id = user_job_history_id;
        this.user_id = user_id;
        this.job_id = job_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_job_history_id() {
        return user_job_history_id;
    }

    public void setUser_job_history_id(int user_job_history_id) {
        this.user_job_history_id = user_job_history_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }
}
