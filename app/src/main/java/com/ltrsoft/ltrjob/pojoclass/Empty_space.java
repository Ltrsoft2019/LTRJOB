package com.ltrsoft.ltrjob.pojoclass;

public class Empty_space {
    private int id,empty_space_id,question_list_id;
    private String empty_space_question;
    private String empty_space_marks;

    public Empty_space(int id, int empty_space_id, int question_list_id, String empty_space_question, String empty_space_marks, String empty_space_correct_answer, String empty_space_examination) {
        this.id = id;
        this.empty_space_id = empty_space_id;
        this.question_list_id = question_list_id;
        this.empty_space_question = empty_space_question;
        this.empty_space_marks = empty_space_marks;
        this.empty_space_correct_answer = empty_space_correct_answer;
        this.empty_space_examination = empty_space_examination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpty_space_id() {
        return empty_space_id;
    }

    public void setEmpty_space_id(int empty_space_id) {
        this.empty_space_id = empty_space_id;
    }

    public int getQuestion_list_id() {
        return question_list_id;
    }

    public void setQuestion_list_id(int question_list_id) {
        this.question_list_id = question_list_id;
    }

    public String getEmpty_space_question() {
        return empty_space_question;
    }

    public void setEmpty_space_question(String empty_space_question) {
        this.empty_space_question = empty_space_question;
    }

    public String getEmpty_space_marks() {
        return empty_space_marks;
    }

    public void setEmpty_space_marks(String empty_space_marks) {
        this.empty_space_marks = empty_space_marks;
    }

    public String getEmpty_space_correct_answer() {
        return empty_space_correct_answer;
    }

    public void setEmpty_space_correct_answer(String empty_space_correct_answer) {
        this.empty_space_correct_answer = empty_space_correct_answer;
    }

    public String getEmpty_space_examination() {
        return empty_space_examination;
    }

    public void setEmpty_space_examination(String empty_space_examination) {
        this.empty_space_examination = empty_space_examination;
    }

    private String empty_space_correct_answer;
    private String empty_space_examination;
}
