package com.ltrsoft.ltrjob.pojoclass;

public class Question_List {

    private int question_list_id,question_type_id;

    public Question_List(int question_list_id, int question_type_id) {
        this.question_list_id = question_list_id;
        this.question_type_id = question_type_id;
    }

    public int getQuestion_list_id() {
        return question_list_id;
    }

    public void setQuestion_list_id(int question_list_id) {
        this.question_list_id = question_list_id;
    }

    public int getQuestion_type_id() {
        return question_type_id;
    }

    public void setQuestion_type_id(int question_type_id) {
        this.question_type_id = question_type_id;
    }
}
