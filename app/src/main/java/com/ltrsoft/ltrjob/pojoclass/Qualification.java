package com.ltrsoft.ltrjob.pojoclass;

public class Qualification {
    private String id,qualification_id,user_id,qualification_level_id;
    private String qualification_school_college,qualification_passing_year,qualification_percentage_cgpa;

    public Qualification(String qualification_id, String user_id, String qualification_level_id,
                         String qualification_school_college, String qualification_passing_year,
                         String qualification_percentage_cgpa) {
        this.qualification_id = qualification_id;
        this.user_id = user_id;
        this.qualification_level_id = qualification_level_id;
        this.qualification_school_college = qualification_school_college;
        this.qualification_passing_year = qualification_passing_year;
        this.qualification_percentage_cgpa = qualification_percentage_cgpa;
    }

    public Qualification(String qualificationSchoolCollege, String qualificationPassingYear, String qualificationPercentageCgpa) {
        this.qualification_school_college = qualificationSchoolCollege;
        this.qualification_passing_year = qualificationPassingYear;
        this.qualification_percentage_cgpa = qualificationPercentageCgpa;
    }


//    public Qualification(String qualificationSchoolCollege, String qualificationPassingYear, String qualificationPercentageCgpa) {
//        this.qualification_school_college = qualificationSchoolCollege;
//        this.qualification_passing_year = qualificationPassingYear;
//        this.qualification_percentage_cgpa = qualificationPercentageCgpa;
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQualification_id() {
        return qualification_id;
    }

    public void setQualification_id(String qualification_id) {
        this.qualification_id = qualification_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getQualification_level_id() {
        return qualification_level_id;
    }

    public void setQualification_level_id(String qualification_level_id) {
        this.qualification_level_id = qualification_level_id;
    }

    public String getQualification_school_college() {
        return qualification_school_college;
    }

    public void setQualification_school_college(String qualification_school_college) {
        this.qualification_school_college = qualification_school_college;
    }

    public String getQualification_passing_year() {
        return qualification_passing_year;
    }

    public void setQualification_passing_year(String qualification_passing_year) {
        this.qualification_passing_year = qualification_passing_year;
    }

    public String getQualification_percentage_cgpa() {
        return qualification_percentage_cgpa;
    }

    public void setQualification_percentage_cgpa(String qualification_percentage_cgpa) {
        this.qualification_percentage_cgpa = qualification_percentage_cgpa;
    }
}
