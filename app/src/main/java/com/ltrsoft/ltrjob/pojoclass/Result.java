package com.ltrsoft.ltrjob.pojoclass;

public class Result {
    private int result_id,exam_user_allocation_id,user_id;
    private String obtained_marks,pass_fail,grade_percentage_cgpa;

    public Result(int result_id, int exam_user_allocation_id, int user_id, String obtained_marks, String pass_fail, String grade_percentage_cgpa) {
        this.result_id = result_id;
        this.exam_user_allocation_id = exam_user_allocation_id;
        this.user_id = user_id;
        this.obtained_marks = obtained_marks;
        this.pass_fail = pass_fail;
        this.grade_percentage_cgpa = grade_percentage_cgpa;
    }

    public Result(String obtainedMarks, String passFail, String gradePercentageCgpa, String examUserAllocationId) {


    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public int getExam_user_allocation_id() {
        return exam_user_allocation_id;
    }

    public void setExam_user_allocation_id(int exam_user_allocation_id) {
        this.exam_user_allocation_id = exam_user_allocation_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getObtained_marks() {
        return obtained_marks;
    }

    public void setObtained_marks(String obtained_marks) {
        this.obtained_marks = obtained_marks;
    }

    public String getPass_fail() {
        return pass_fail;
    }

    public void setPass_fail(String pass_fail) {
        this.pass_fail = pass_fail;
    }

    public String getGrade_percentage_cgpa() {
        return grade_percentage_cgpa;
    }

    public void setGrade_percentage_cgpa(String grade_percentage_cgpa) {
        this.grade_percentage_cgpa = grade_percentage_cgpa;
    }
}
