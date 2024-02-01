package com.ltrsoft.ltrjob.pojoclass;

public class Experience {
    private int id,experience_id,user_id,experiance_type_id;
    private String  companyloogo,experience_company_name,experiance_start_date,experiance_end_date,experiance_payment,experiance_technology,experiance_project_name,experiance_position;

    public Experience(int id, int experience_id, int user_id, int experiance_type_id, String experience_company_name, String experiance_start_date, String experiance_end_date, String experiance_payment, String experiance_technology, String experiance_project_name, String experiance_position) {
        this.id = id;
        this.experience_id = experience_id;
        this.user_id = user_id;
        this.experiance_type_id = experiance_type_id;
//        this.experience_company_name = experience_company_name;
//        this.experiance_start_date = experiance_start_date;
//        this.experiance_end_date = experiance_end_date;
//        this.experiance_payment = experiance_payment;
//        this.experiance_technology = experiance_technology;
//        this.experiance_project_name = experiance_project_name;
//        this.experiance_position = experiance_position;
    }

    public Experience(String experienceCompanyName, String experianceStartDate, String experianceEndDate, String experiancePayment, String experianceTechnology, String experianceProjectName, String experiancePosition) {
        this.experience_company_name = experienceCompanyName;
        this.experiance_start_date = experianceStartDate;
        this.experiance_end_date = experianceEndDate;
        this.experiance_payment = experiancePayment;
        this.experiance_technology = experianceTechnology;
        this.experiance_project_name = experianceProjectName;
        this.experiance_position = experiancePosition;

    }

    public Experience(String imageurl, String experienceCompanyName, String experianceStartDate, String experianceEndDate, String experiancePayment, String experianceTechnology, String experianceProjectName, String experiancePosition) {
   this.companyloogo=imageurl;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExperience_id() {
        return experience_id;
    }

    public void setExperience_id(int experience_id) {
        this.experience_id = experience_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getExperiance_type_id() {
        return experiance_type_id;
    }

    public void setExperiance_type_id(int experiance_type_id) {
        this.experiance_type_id = experiance_type_id;
    }

    public String getExperience_company_name() {
        return experience_company_name;
    }

    public void setExperience_company_name(String experience_company_name) {
        this.experience_company_name = experience_company_name;
    }

    public String getExperiance_start_date() {
        return experiance_start_date;
    }

    public void setExperiance_start_date(String experiance_start_date) {
        this.experiance_start_date = experiance_start_date;
    }

    public String getExperiance_end_date() {
        return experiance_end_date;
    }

    public void setExperiance_end_date(String experiance_end_date) {
        this.experiance_end_date = experiance_end_date;
    }

    public String getExperiance_payment() {
        return experiance_payment;
    }

    public void setExperiance_payment(String experiance_payment) {
        this.experiance_payment = experiance_payment;
    }

    public String getExperiance_technology() {
        return experiance_technology;
    }

    public void setExperiance_technology(String experiance_technology) {
        this.experiance_technology = experiance_technology;
    }

    public String getExperiance_project_name() {
        return experiance_project_name;
    }

    public void setExperiance_project_name(String experiance_project_name) {
        this.experiance_project_name = experiance_project_name;
    }

    public String getExperiance_position() {
        return experiance_position;
    }

    public void setExperiance_position(String experiance_position) {
        this.experiance_position = experiance_position;
    }
}
