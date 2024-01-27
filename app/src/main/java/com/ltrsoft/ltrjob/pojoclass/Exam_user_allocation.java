package com.ltrsoft.ltrjob.pojoclass;

public class Exam_user_allocation {
    private int id,exam_user_allocation_id,exam_id,user_id;

    public Exam_user_allocation(int id, int exam_user_allocation_id, int exam_id, int user_id) {
        this.id = id;
        this.exam_user_allocation_id = exam_user_allocation_id;
        this.exam_id = exam_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExam_user_allocation_id() {
        return exam_user_allocation_id;
    }

    public void setExam_user_allocation_id(int exam_user_allocation_id) {
        this.exam_user_allocation_id = exam_user_allocation_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
