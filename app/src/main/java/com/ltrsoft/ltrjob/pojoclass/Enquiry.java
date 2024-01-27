package com.ltrsoft.ltrjob.pojoclass;

public class Enquiry {
    private int id,enquiry_id;
    private String enquiry_name,enquiry_email,enquiry_subject,enquiry_phone,enquiry_description;

    public Enquiry(int id, int enquiry_id, String enquiry_name, String enquiry_email, String enquiry_subject, String enquiry_phone, String enquiry_description) {
        this.id = id;
        this.enquiry_id = enquiry_id;
        this.enquiry_name = enquiry_name;
        this.enquiry_email = enquiry_email;
        this.enquiry_subject = enquiry_subject;
        this.enquiry_phone = enquiry_phone;
        this.enquiry_description = enquiry_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnquiry_id() {
        return enquiry_id;
    }

    public void setEnquiry_id(int enquiry_id) {
        this.enquiry_id = enquiry_id;
    }

    public String getEnquiry_name() {
        return enquiry_name;
    }

    public void setEnquiry_name(String enquiry_name) {
        this.enquiry_name = enquiry_name;
    }

    public String getEnquiry_email() {
        return enquiry_email;
    }

    public void setEnquiry_email(String enquiry_email) {
        this.enquiry_email = enquiry_email;
    }

    public String getEnquiry_subject() {
        return enquiry_subject;
    }

    public void setEnquiry_subject(String enquiry_subject) {
        this.enquiry_subject = enquiry_subject;
    }

    public String getEnquiry_phone() {
        return enquiry_phone;
    }

    public void setEnquiry_phone(String enquiry_phone) {
        this.enquiry_phone = enquiry_phone;
    }

    public String getEnquiry_description() {
        return enquiry_description;
    }

    public void setEnquiry_description(String enquiry_description) {
        this.enquiry_description = enquiry_description;
    }
}
