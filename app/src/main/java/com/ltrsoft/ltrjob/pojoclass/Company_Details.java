package com.ltrsoft.ltrjob.pojoclass;

public class Company_Details {

   private String company_id,company_name,company_logo,company_email,company_phone,company_domain,company_hoaddress,
    company_hocity,company_hodistrict,company_hostate,company_hocountry;

    public Company_Details( String company_name, String company_logo, String company_email,
                           String company_phone, String company_domain, String company_hoaddress,
                           String company_hocity, String company_hodistrict, String company_hostate,
                           String company_hocountry) {


        this.company_name = company_name;
        this.company_logo = company_logo;
        this.company_email = company_email;
        this.company_phone = company_phone;
        this.company_domain = company_domain;
        this.company_hoaddress = company_hoaddress;
        this.company_hocity = company_hocity;
        this.company_hodistrict = company_hodistrict;
        this.company_hostate = company_hostate;
        this.company_hocountry = company_hocountry;
    }


//    public Company_Details(String companyName, String companyLogo, String companyEmail, String companyPhone,
//                           String companyDomain, String companyHoaddress, String companyHocity,
//                           String companyHodistrict, String companyHostate, String companyHocountry) {
//
//        this.company_name = company_name;
//        this.company_logo = company_logo;
//        this.company_email = company_email;
//        this.company_phone = company_phone;
//        this.company_domain = company_domain;
//        this.company_hoaddress = company_hoaddress;
//        this.company_hocity = company_hocity;
//        this.company_hodistrict = company_hodistrict;
//        this.company_hostate = company_hostate;
//        this.company_hocountry = company_hocountry;
//    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public String getCompany_phone() {
        return company_phone;
    }

    public void setCompany_phone(String company_phone) {
        this.company_phone = company_phone;
    }

    public String getCompany_domain() {
        return company_domain;
    }

    public void setCompany_domain(String company_domain) {
        this.company_domain = company_domain;
    }

    public String getCompany_hoaddress() {
        return company_hoaddress;
    }

    public void setCompany_hoaddress(String company_hoaddress) {
        this.company_hoaddress = company_hoaddress;
    }

    public String getCompany_hocity() {
        return company_hocity;
    }

    public void setCompany_hocity(String company_hocity) {
        this.company_hocity = company_hocity;
    }

    public String getCompany_hodistrict() {
        return company_hodistrict;
    }

    public void setCompany_hodistrict(String company_hodistrict) {
        this.company_hodistrict = company_hodistrict;
    }

    public String getCompany_hostate() {
        return company_hostate;
    }

    public void setCompany_hostate(String company_hostate) {
        this.company_hostate = company_hostate;
    }

    public String getCompany_hocountry() {
        return company_hocountry;
    }

    public void setCompany_hocountry(String company_hocountry) {
        this.company_hocountry = company_hocountry;
    }
}
