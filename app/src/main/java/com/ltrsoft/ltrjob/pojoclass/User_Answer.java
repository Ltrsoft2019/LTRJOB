package com.ltrsoft.ltrjob.pojoclass;

public class User_Answer {

    private int id,user_answer_id,exam_user_allocation_id,question_list_id;

    private String answer_text,answer_file;

    public User_Answer(int id, int user_answer_id, int exam_user_allocation_id, int question_list_id, String answer_text, String answer_file) {
        this.id = id;
        this.user_answer_id = user_answer_id;
        this.exam_user_allocation_id = exam_user_allocation_id;
        this.question_list_id = question_list_id;
        this.answer_text = answer_text;
        this.answer_file = answer_file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_answer_id() {
        return user_answer_id;
    }

    public void setUser_answer_id(int user_answer_id) {
        this.user_answer_id = user_answer_id;
    }

    public int getExam_user_allocation_id() {
        return exam_user_allocation_id;
    }

    public void setExam_user_allocation_id(int exam_user_allocation_id) {
        this.exam_user_allocation_id = exam_user_allocation_id;
    }

    public int getQuestion_list_id() {
        return question_list_id;
    }

    public void setQuestion_list_id(int question_list_id) {
        this.question_list_id = question_list_id;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

    public String getAnswer_file() {
        return answer_file;
    }

    public void setAnswer_file(String answer_file) {
        this.answer_file = answer_file;
    }
}
