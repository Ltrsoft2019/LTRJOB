package com.ltrsoft.ltrjob.pojoclass;

public class job {

    private String  company_name,company_email,job_description,company_phone,job_position,company_hoaddress,job_category_name,job_salary,company_id,imageurl,job_id;

    public job(String company_name, String company_email, String job_description, String company_phone,
               String job_position, String company_hoaddress, String job_category_name, String job_salary,
               String company_id, String imageurl,String job_id) {

        this.company_hoaddress = company_hoaddress;
        this.job_category_name = job_category_name;
        this.job_salary = job_salary;
        this.company_id = company_id;
        this.imageurl = imageurl;
        this.company_name = company_name;
        this.company_email = company_email;
        this.job_description = job_description;
        this.company_phone = company_phone;
        this.job_position = job_position;
        this.job_id = job_id;
    }

    public job(String companyName, String companyEmail, String jobDescription, String companyPhone,
               String jobPosition) {
        this.company_name = companyName;
        this.company_email = companyEmail;
        this.job_description = jobDescription;
        this.company_phone = companyPhone;
        this.job_position = jobPosition;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getCompany_phone() {
        return company_phone;
    }

    public void setCompany_phone(String company_phone) {
        this.company_phone = company_phone;
    }

    public String getJob_position() {
        return job_position;
    }

    public void setJob_position(String job_position) {
        this.job_position = job_position;
    }

    public String getCompany_hoaddress() {
        return company_hoaddress;
    }

    public void setCompany_hoaddress(String company_hoaddress) {
        this.company_hoaddress = company_hoaddress;
    }

    public String getJob_category_name() {
        return job_category_name;
    }

    public void setJob_category_name(String job_category_name) {
        this.job_category_name = job_category_name;
    }

    public String getJob_salary() {
        return job_salary;
    }

    public void setJob_salary(String job_salary) {
        this.job_salary = job_salary;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }
}
