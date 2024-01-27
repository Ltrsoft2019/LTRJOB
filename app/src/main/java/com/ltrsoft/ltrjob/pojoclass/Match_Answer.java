package com.ltrsoft.ltrjob.pojoclass;

public class Match_Answer {
    private int match_answer_id,match_list_a_id,match_list_b_id,match_id;
    private String match_answer_marks;

    public Match_Answer(int match_answer_id, int match_list_a_id, int match_list_b_id, int match_id, String match_answer_marks) {
        this.match_answer_id = match_answer_id;
        this.match_list_a_id = match_list_a_id;
        this.match_list_b_id = match_list_b_id;
        this.match_id = match_id;
        this.match_answer_marks = match_answer_marks;
    }

    public int getMatch_answer_id() {
        return match_answer_id;
    }

    public void setMatch_answer_id(int match_answer_id) {
        this.match_answer_id = match_answer_id;
    }

    public int getMatch_list_a_id() {
        return match_list_a_id;
    }

    public void setMatch_list_a_id(int match_list_a_id) {
        this.match_list_a_id = match_list_a_id;
    }

    public int getMatch_list_b_id() {
        return match_list_b_id;
    }

    public void setMatch_list_b_id(int match_list_b_id) {
        this.match_list_b_id = match_list_b_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getMatch_answer_marks() {
        return match_answer_marks;
    }

    public void setMatch_answer_marks(String match_answer_marks) {
        this.match_answer_marks = match_answer_marks;
    }
}
