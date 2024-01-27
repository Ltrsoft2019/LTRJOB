package com.ltrsoft.ltrjob.pojoclass;

public class To_Do_List {
    private int to_do_list_id,user_id,id;
    private String to_do_list_message,to_do_list_status;

    public To_Do_List(int to_do_list_id, int user_id, int id, String to_do_list_message, String to_do_list_status) {
        this.to_do_list_id = to_do_list_id;
        this.user_id = user_id;
        this.id = id;
        this.to_do_list_message = to_do_list_message;
        this.to_do_list_status = to_do_list_status;
    }

    public int getTo_do_list_id() {
        return to_do_list_id;
    }

    public void setTo_do_list_id(int to_do_list_id) {
        this.to_do_list_id = to_do_list_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTo_do_list_message() {
        return to_do_list_message;
    }

    public void setTo_do_list_message(String to_do_list_message) {
        this.to_do_list_message = to_do_list_message;
    }

    public String getTo_do_list_status() {
        return to_do_list_status;
    }

    public void setTo_do_list_status(String to_do_list_status) {
        this.to_do_list_status = to_do_list_status;
    }
}
