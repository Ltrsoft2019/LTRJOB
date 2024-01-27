package com.ltrsoft.ltrjob.pojoclass;

public class User_Language {

    private int id,user_language_id,user_id,language_id;

    public User_Language(int id, int user_language_id, int user_id, int language_id) {
        this.id = id;
        this.user_language_id = user_language_id;
        this.user_id = user_id;
        this.language_id = language_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_language_id() {
        return user_language_id;
    }

    public void setUser_language_id(int user_language_id) {
        this.user_language_id = user_language_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
}
