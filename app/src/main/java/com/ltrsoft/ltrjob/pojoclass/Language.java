package com.ltrsoft.ltrjob.pojoclass;

public class Language {
    private int id;
    private String language_name,language_id;

    public Language(int id, String language_id, String language_name) {
        this.id = id;
        this.language_id = language_id;
        this.language_name = language_name;
    }

    public Language(String languageName) {
        this.language_name = language_name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(String language_id) {
        this.language_id = language_id;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }
}
