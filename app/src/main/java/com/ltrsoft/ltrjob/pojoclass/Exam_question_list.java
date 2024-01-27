package com.ltrsoft.ltrjob.pojoclass;

public class Exam_question_list {
    private int id,exam_question_list_id,exam_id,question_list_id;

    public Exam_question_list(int id, int exam_question_list_id, int exam_id, int question_list_id) {
        this.id = id;
        this.exam_question_list_id = exam_question_list_id;
        this.exam_id = exam_id;
        this.question_list_id = question_list_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExam_question_list_id() {
        return exam_question_list_id;
    }

    public void setExam_question_list_id(int exam_question_list_id) {
        this.exam_question_list_id = exam_question_list_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public int getQuestion_list_id() {
        return question_list_id;
    }

    public void setQuestion_list_id(int question_list_id) {
        this.question_list_id = question_list_id;
    }
}
