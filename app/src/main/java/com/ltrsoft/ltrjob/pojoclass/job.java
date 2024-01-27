package com.ltrsoft.ltrjob.pojoclass;

public class job {
    private int id,job_id,company_id,job_category_id;
    private String job_website_to_apply,job_start_date_to_apply,job_end_date_to_apply,job_position,job_salary,job_description,job_criteria_to_apply;

    public job(int id, int job_id, int company_id, int job_category_id, String job_website_to_apply, String job_start_date_to_apply, String job_end_date_to_apply, String job_position, String job_salary, String job_description, String job_criteria_to_apply) {
        this.id = id;
        this.job_id = job_id;
        this.company_id = company_id;
        this.job_category_id = job_category_id;
        this.job_website_to_apply = job_website_to_apply;
        this.job_start_date_to_apply = job_start_date_to_apply;
        this.job_end_date_to_apply = job_end_date_to_apply;
        this.job_position = job_position;
        this.job_salary = job_salary;
        this.job_description = job_description;
        this.job_criteria_to_apply = job_criteria_to_apply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getJob_category_id() {
        return job_category_id;
    }

    public void setJob_category_id(int job_category_id) {
        this.job_category_id = job_category_id;
    }

    public String getJob_website_to_apply() {
        return job_website_to_apply;
    }

    public void setJob_website_to_apply(String job_website_to_apply) {
        this.job_website_to_apply = job_website_to_apply;
    }

    public String getJob_start_date_to_apply() {
        return job_start_date_to_apply;
    }

    public void setJob_start_date_to_apply(String job_start_date_to_apply) {
        this.job_start_date_to_apply = job_start_date_to_apply;
    }

    public String getJob_end_date_to_apply() {
        return job_end_date_to_apply;
    }

    public void setJob_end_date_to_apply(String job_end_date_to_apply) {
        this.job_end_date_to_apply = job_end_date_to_apply;
    }

    public String getJob_position() {
        return job_position;
    }

    public void setJob_position(String job_position) {
        this.job_position = job_position;
    }

    public String getJob_salary() {
        return job_salary;
    }

    public void setJob_salary(String job_salary) {
        this.job_salary = job_salary;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getJob_criteria_to_apply() {
        return job_criteria_to_apply;
    }

    public void setJob_criteria_to_apply(String job_criteria_to_apply) {
        this.job_criteria_to_apply = job_criteria_to_apply;
    }
}
