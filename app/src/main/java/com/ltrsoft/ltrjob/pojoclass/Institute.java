package com.ltrsoft.ltrjob.pojoclass;

public class Institute {
    private int id,institute_id;
    private String institute_name,institute_logo,institute_founded_in,institute_founder,institute_address,institute_contact,institute_website,institute_email,institute_description,instiyute_vission,institute_mission,institute_director_msg;

    public Institute(int id, int institute_id, String institute_name, String institute_logo, String institute_founded_in, String institute_founder, String institute_address, String institute_contact, String institute_website, String institute_email, String institute_description, String instiyute_vission, String institute_mission, String institute_director_msg) {
        this.id = id;
        this.institute_id = institute_id;
        this.institute_name = institute_name;
        this.institute_logo = institute_logo;
        this.institute_founded_in = institute_founded_in;
        this.institute_founder = institute_founder;
        this.institute_address = institute_address;
        this.institute_contact = institute_contact;
        this.institute_website = institute_website;
        this.institute_email = institute_email;
        this.institute_description = institute_description;
        this.instiyute_vission = instiyute_vission;
        this.institute_mission = institute_mission;
        this.institute_director_msg = institute_director_msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstitute_id() {
        return institute_id;
    }

    public void setInstitute_id(int institute_id) {
        this.institute_id = institute_id;
    }

    public String getInstitute_name() {
        return institute_name;
    }

    public void setInstitute_name(String institute_name) {
        this.institute_name = institute_name;
    }

    public String getInstitute_logo() {
        return institute_logo;
    }

    public void setInstitute_logo(String institute_logo) {
        this.institute_logo = institute_logo;
    }

    public String getInstitute_founded_in() {
        return institute_founded_in;
    }

    public void setInstitute_founded_in(String institute_founded_in) {
        this.institute_founded_in = institute_founded_in;
    }

    public String getInstitute_founder() {
        return institute_founder;
    }

    public void setInstitute_founder(String institute_founder) {
        this.institute_founder = institute_founder;
    }

    public String getInstitute_address() {
        return institute_address;
    }

    public void setInstitute_address(String institute_address) {
        this.institute_address = institute_address;
    }

    public String getInstitute_contact() {
        return institute_contact;
    }

    public void setInstitute_contact(String institute_contact) {
        this.institute_contact = institute_contact;
    }

    public String getInstitute_website() {
        return institute_website;
    }

    public void setInstitute_website(String institute_website) {
        this.institute_website = institute_website;
    }

    public String getInstitute_email() {
        return institute_email;
    }

    public void setInstitute_email(String institute_email) {
        this.institute_email = institute_email;
    }

    public String getInstitute_description() {
        return institute_description;
    }

    public void setInstitute_description(String institute_description) {
        this.institute_description = institute_description;
    }

    public String getInstiyute_vission() {
        return instiyute_vission;
    }

    public void setInstiyute_vission(String instiyute_vission) {
        this.instiyute_vission = instiyute_vission;
    }

    public String getInstitute_mission() {
        return institute_mission;
    }

    public void setInstitute_mission(String institute_mission) {
        this.institute_mission = institute_mission;
    }

    public String getInstitute_director_msg() {
        return institute_director_msg;
    }

    public void setInstitute_director_msg(String institute_director_msg) {
        this.institute_director_msg = institute_director_msg;
    }
}
