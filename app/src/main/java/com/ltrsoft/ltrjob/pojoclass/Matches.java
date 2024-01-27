package com.ltrsoft.ltrjob.pojoclass;

public class Matches {
    private int id,match_id,question_list_id;
    private String match_question;

    public Matches(int id, int match_id, int question_list_id, String match_question) {
        this.id = id;
        this.match_id = match_id;
        this.question_list_id = question_list_id;
        this.match_question = match_question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getQuestion_list_id() {
        return question_list_id;
    }

    public void setQuestion_list_id(int question_list_id) {
        this.question_list_id = question_list_id;
    }

    public String getMatch_question() {
        return match_question;
    }

    public void setMatch_question(String match_question) {
        this.match_question = match_question;
    }
}
