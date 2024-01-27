package com.ltrsoft.ltrjob.pojoclass;

public class Question_Type {

    private int question_type_id,id;

    private String question_type_name;

    public Question_Type(int question_type_id, int id, String question_type_name) {
        this.question_type_id = question_type_id;
        this.id = id;
        this.question_type_name = question_type_name;
    }

    public int getQuestion_type_id() {
        return question_type_id;
    }

    public void setQuestion_type_id(int question_type_id) {
        this.question_type_id = question_type_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion_type_name() {
        return question_type_name;
    }

    public void setQuestion_type_name(String question_type_name) {
        this.question_type_name = question_type_name;
    }
}
