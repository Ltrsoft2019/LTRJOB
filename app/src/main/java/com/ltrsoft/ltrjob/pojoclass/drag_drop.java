package com.ltrsoft.ltrjob.pojoclass;

public class drag_drop {
    private int id,draggrop_id,question_list_id;
    private String drag_drop_question,drag_drop_question_description;

    public drag_drop(int id, int draggrop_id, int question_list_id, String drag_drop_question, String drag_drop_question_description) {
        this.id = id;
        this.draggrop_id = draggrop_id;
        this.question_list_id = question_list_id;
        this.drag_drop_question = drag_drop_question;
        this.drag_drop_question_description = drag_drop_question_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDraggrop_id() {
        return draggrop_id;
    }

    public void setDraggrop_id(int draggrop_id) {
        this.draggrop_id = draggrop_id;
    }

    public int getQuestion_list_id() {
        return question_list_id;
    }

    public void setQuestion_list_id(int question_list_id) {
        this.question_list_id = question_list_id;
    }

    public String getDrag_drop_question() {
        return drag_drop_question;
    }

    public void setDrag_drop_question(String drag_drop_question) {
        this.drag_drop_question = drag_drop_question;
    }

    public String getDrag_drop_question_description() {
        return drag_drop_question_description;
    }

    public void setDrag_drop_question_description(String drag_drop_question_description) {
        this.drag_drop_question_description = drag_drop_question_description;
    }
}
