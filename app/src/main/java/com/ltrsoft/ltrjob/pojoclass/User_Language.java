package com.ltrsoft.ltrjob.pojoclass;

public class User_Language {

    private String id,user_language_id,user_id,language_id;

    public User_Language(String id, String user_language_id, String user_id, String language_id) {
        this.id = id;
        this.user_language_id = user_language_id;
        this.user_id = user_id;
        this.language_id = language_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_language_id() {
        return user_language_id;
    }

    public void setUser_language_id(String user_language_id) {
        this.user_language_id = user_language_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(String language_id) {
        this.language_id = language_id;
    }
}
