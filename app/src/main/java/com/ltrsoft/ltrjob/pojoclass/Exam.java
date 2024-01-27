package com.ltrsoft.ltrjob.pojoclass;

import java.util.ArrayList;

public class Exam {
    private int id,exam_id;

    private String exam_name,total_marks,exam_start_date,exam_time,exam_description,passing_marks;

//    public Exam(int id, int exam_id, String exam_name, String total_marks, String exam_start_date, String exam_time, String exam_description, String passing_marks) {
//        this.id = id;
//        this.exam_id = exam_id;
//        this.exam_name = exam_name;
//        this.total_marks = total_marks;
//        this.exam_start_date = exam_start_date;
//        this.exam_time = exam_time;
//        this.exam_description = exam_description;
//        this.passing_marks = passing_marks;
//    }

    public Exam(int id, int exam_id,String examName, String totalMarks, String examStartDate, String examTime, String examDescription, String passingMarks) {

        this.id = id;
        this.exam_id = exam_id;
        this.exam_name = exam_name;
        this.total_marks = total_marks;
        this.exam_start_date = exam_start_date;
        this.exam_time = exam_time;
        this.exam_description = exam_description;
        this.passing_marks = passing_marks;

    }

    public Exam(String totalMarks) {
        this.total_marks = total_marks;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public String getTotal_marks() {
        return total_marks;
    }

    public void setTotal_marks(String total_marks) {
        this.total_marks = total_marks;
    }

    public String getExam_start_date() {
        return exam_start_date;
    }

    public void setExam_start_date(String exam_start_date) {
        this.exam_start_date = exam_start_date;
    }

    public String getExam_time() {
        return exam_time;
    }

    public void setExam_time(String exam_time) {
        this.exam_time = exam_time;
    }

    public String getExam_description() {
        return exam_description;
    }

    public void setExam_description(String exam_description) {
        this.exam_description = exam_description;
    }

    public String getPassing_marks() {
        return passing_marks;
    }

    public void setPassing_marks(String passing_marks) {
        this.passing_marks = passing_marks;
    }
}
