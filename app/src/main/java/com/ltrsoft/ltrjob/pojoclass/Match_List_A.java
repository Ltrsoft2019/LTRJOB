package com.ltrsoft.ltrjob.pojoclass;

public class Match_List_A {
    private int match_list_A_id,match_id;
    private String match_list_A_option;

    public Match_List_A(int match_list_A_id, int match_id, String match_list_A_option) {
        this.match_list_A_id = match_list_A_id;
        this.match_id = match_id;
        this.match_list_A_option = match_list_A_option;
    }

    public int getMatch_list_A_id() {
        return match_list_A_id;
    }

    public void setMatch_list_A_id(int match_list_A_id) {
        this.match_list_A_id = match_list_A_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getMatch_list_A_option() {
        return match_list_A_option;
    }

    public void setMatch_list_A_option(String match_list_A_option) {
        this.match_list_A_option = match_list_A_option;
    }
}
