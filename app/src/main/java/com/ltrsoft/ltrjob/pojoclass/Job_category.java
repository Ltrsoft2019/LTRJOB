package com.ltrsoft.ltrjob.pojoclass;

public class Job_category {
    private int id,job_category_id;
    private String job_category_name;

    public Job_category(int id, int job_category_id, String job_category_name) {
        this.id = id;
        this.job_category_id = job_category_id;
        this.job_category_name = job_category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJob_category_id() {
        return job_category_id;
    }

    public void setJob_category_id(int job_category_id) {
        this.job_category_id = job_category_id;
    }

    public String getJob_category_name() {
        return job_category_name;
    }

    public void setJob_category_name(String job_category_name) {
        this.job_category_name = job_category_name;
    }
}
