package com.ltrsoft.ltrjob.pojoclass;

public class Mini_Project {

    private int mini_project_id,user_id,id;
    private String mini_project_title,mini_project_start_date,mini_project_end_date,mini_project_topic,mini_project_technologies_used,mini_project_problem_statement,mini_project_test_cases;

    public Mini_Project(int mini_project_id, int user_id, int id, String mini_project_title, String mini_project_start_date, String mini_project_end_date, String mini_project_topic, String mini_project_technologies_used, String mini_project_problem_statement, String mini_project_test_cases) {
        this.mini_project_id = mini_project_id;
        this.user_id = user_id;
        this.id = id;
        this.mini_project_title = mini_project_title;
        this.mini_project_start_date = mini_project_start_date;
        this.mini_project_end_date = mini_project_end_date;
        this.mini_project_topic = mini_project_topic;
        this.mini_project_technologies_used = mini_project_technologies_used;
        this.mini_project_problem_statement = mini_project_problem_statement;
        this.mini_project_test_cases = mini_project_test_cases;
    }

    public Mini_Project(String miniProjectTitle, String miniProjectStartDate, String miniProjectEndDate, String miniProjectTopic, String miniProjectTechnologiesUsed) {
        this.mini_project_title = miniProjectTitle;
        this.mini_project_start_date = miniProjectStartDate;
        this.mini_project_end_date = miniProjectEndDate;
        this.mini_project_topic = miniProjectTopic;
        this.mini_project_technologies_used = miniProjectTechnologiesUsed;

    }

    public int getMini_project_id() {
        return mini_project_id;
    }

    public void setMini_project_id(int mini_project_id) {
        this.mini_project_id = mini_project_id;
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

    public String getMini_project_title() {
        return mini_project_title;
    }

    public void setMini_project_title(String mini_project_title) {
        this.mini_project_title = mini_project_title;
    }

    public String getMini_project_start_date() {
        return mini_project_start_date;
    }

    public void setMini_project_start_date(String mini_project_start_date) {
        this.mini_project_start_date = mini_project_start_date;
    }

    public String getMini_project_end_date() {
        return mini_project_end_date;
    }

    public void setMini_project_end_date(String mini_project_end_date) {
        this.mini_project_end_date = mini_project_end_date;
    }

    public String getMini_project_topic() {
        return mini_project_topic;
    }

    public void setMini_project_topic(String mini_project_topic) {
        this.mini_project_topic = mini_project_topic;
    }

    public String getMini_project_technologies_used() {
        return mini_project_technologies_used;
    }

    public void setMini_project_technologies_used(String mini_project_technologies_used) {
        this.mini_project_technologies_used = mini_project_technologies_used;
    }

    public String getMini_project_problem_statement() {
        return mini_project_problem_statement;
    }

    public void setMini_project_problem_statement(String mini_project_problem_statement) {
        this.mini_project_problem_statement = mini_project_problem_statement;
    }

    public String getMini_project_test_cases() {
        return mini_project_test_cases;
    }

    public void setMini_project_test_cases(String mini_project_test_cases) {
        this.mini_project_test_cases = mini_project_test_cases;
    }
}
