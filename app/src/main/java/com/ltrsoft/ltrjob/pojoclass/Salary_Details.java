package com.ltrsoft.ltrjob.pojoclass;

public class Salary_Details {

    private int salary_details_id,id,user_id;
    private String salary_amount;


    public Salary_Details(int salary_details_id, int id, int user_id, String salary_amount) {
        this.salary_details_id = salary_details_id;
        this.id = id;
        this.user_id = user_id;
        this.salary_amount = salary_amount;
    }

    public int getSalary_details_id() {
        return salary_details_id;
    }

    public void setSalary_details_id(int salary_details_id) {
        this.salary_details_id = salary_details_id;
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

    public String getSalary_amount() {
        return salary_amount;
    }

    public void setSalary_amount(String salary_amount) {
        this.salary_amount = salary_amount;
    }
}
