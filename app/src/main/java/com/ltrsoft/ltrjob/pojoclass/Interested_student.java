package com.ltrsoft.ltrjob.pojoclass;

public class Interested_student
{
    private int id;
    private String interested_student_id,interested_student_name,interested_student_class,interested_student_passing_year,interested_student_college,interested_student_course,interested_student_mobile;

    public Interested_student(int id, String interested_student_id, String interested_student_name, String interested_student_class, String interested_student_passing_year, String interested_student_college, String interested_student_course, String interested_student_mobile) {
        this.id = id;
        this.interested_student_id = interested_student_id;
        this.interested_student_name = interested_student_name;
        this.interested_student_class = interested_student_class;
        this.interested_student_passing_year = interested_student_passing_year;
        this.interested_student_college = interested_student_college;
        this.interested_student_course = interested_student_course;
        this.interested_student_mobile = interested_student_mobile;
    }

    public Interested_student(String interestedStudentName, String interestedStudentClass, String interestedStudentPassingYear, String interestedStudentCollege, String interestedStudentCourse, String interestedStudentMobile) {
        this.interested_student_name = interested_student_name;
        this.interested_student_class = interested_student_class;
        this.interested_student_passing_year = interested_student_passing_year;
        this.interested_student_college = interested_student_college;
        this.interested_student_course = interested_student_course;
        this.interested_student_mobile = interested_student_mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInterested_student_id() {
        return interested_student_id;
    }

    public void setInterested_student_id(String interested_student_id) {
        this.interested_student_id = interested_student_id;
    }

    public String getInterested_student_name() {
        return interested_student_name;
    }

    public void setInterested_student_name(String interested_student_name) {
        this.interested_student_name = interested_student_name;
    }

    public String getInterested_student_class() {
        return interested_student_class;
    }

    public void setInterested_student_class(String interested_student_class) {
        this.interested_student_class = interested_student_class;
    }

    public String getInterested_student_passing_year() {
        return interested_student_passing_year;
    }

    public void setInterested_student_passing_year(String interested_student_passing_year) {
        this.interested_student_passing_year = interested_student_passing_year;
    }

    public String getInterested_student_college() {
        return interested_student_college;
    }

    public void setInterested_student_college(String interested_student_college) {
        this.interested_student_college = interested_student_college;
    }

    public String getInterested_student_course() {
        return interested_student_course;
    }

    public void setInterested_student_course(String interested_student_course) {
        this.interested_student_course = interested_student_course;
    }

    public String getInterested_student_mobile() {
        return interested_student_mobile;
    }

    public void setInterested_student_mobile(String interested_student_mobile) {
        this.interested_student_mobile = interested_student_mobile;
    }
}
