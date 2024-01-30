package com.ltrsoft.ltrjob.pojoclass;

public class Qualification {
    private int id,qualification_id,user_id,qualification_level_id;
    private String qualification_school_college,qualification_passing_year,qualification_percentage_cgpa;

    public Qualification(int id, int qualification_id, int user_id, int qualification_level_id, String qualification_school_college, String qualification_passing_year, String qualification_percentage_cgpa) {
        this.id = id;
        this.qualification_id = qualification_id;
        this.user_id = user_id;

    }

    public Qualification(int qualificationLevelId, String qualificationSchoolCollege, String qualificationPassingYear, String qualificationPercentageCgpa) {

        this.qualification_level_id = qualificationLevelId;
        this.qualification_school_college = qualificationSchoolCollege;
        this.qualification_passing_year = qualificationPassingYear;
        this.qualification_percentage_cgpa = qualificationPercentageCgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQualification_id() {
        return qualification_id;
    }

    public void setQualification_id(int qualification_id) {
        this.qualification_id = qualification_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQualification_level_id() {
        return qualification_level_id;
    }

    public void setQualification_level_id(int qualification_level_id) {
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
