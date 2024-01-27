package com.ltrsoft.ltrjob.pojoclass;

public class Match_List_B {
    private int match_list_B_id,match_id;
    private String match_list_B_option;

    public Match_List_B(int match_list_B_id, int match_id, String match_list_B_option) {
        this.match_list_B_id = match_list_B_id;
        this.match_id = match_id;
        this.match_list_B_option = match_list_B_option;
    }

    public int getMatch_list_B_id() {
        return match_list_B_id;
    }

    public void setMatch_list_B_id(int match_list_B_id) {
        this.match_list_B_id = match_list_B_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getMatch_list_B_option() {
        return match_list_B_option;
    }

    public void setMatch_list_B_option(String match_list_B_option) {
        this.match_list_B_option = match_list_B_option;
    }
}
