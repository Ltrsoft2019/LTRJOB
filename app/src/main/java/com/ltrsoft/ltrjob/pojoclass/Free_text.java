package com.ltrsoft.ltrjob.pojoclass;

public class Free_text {
    private int id,free_text_id,question_list_id;

    public Free_text(int id, int free_text_id, int question_list_id, String free_text_question, String free_text_keyword, String free_text_marks) {
        this.id = id;
        this.free_text_id = free_text_id;
        this.question_list_id = question_list_id;
        this.free_text_question = free_text_question;
        this.free_text_keyword = free_text_keyword;
        this.free_text_marks = free_text_marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFree_text_id() {
        return free_text_id;
    }

    public void setFree_text_id(int free_text_id) {
        this.free_text_id = free_text_id;
    }

    public int getQuestion_list_id() {
        return question_list_id;
    }

    public void setQuestion_list_id(int question_list_id) {
        this.question_list_id = question_list_id;
    }

    public String getFree_text_question() {
        return free_text_question;
    }

    public void setFree_text_question(String free_text_question) {
        this.free_text_question = free_text_question;
    }

    public String getFree_text_keyword() {
        return free_text_keyword;
    }

    public void setFree_text_keyword(String free_text_keyword) {
        this.free_text_keyword = free_text_keyword;
    }

    public String getFree_text_marks() {
        return free_text_marks;
    }

    public void setFree_text_marks(String free_text_marks) {
        this.free_text_marks = free_text_marks;
    }

    private String free_text_question,free_text_keyword,free_text_marks;
}
