package com.ltrsoft.ltrjob.pojoclass;

public class Mcq {
    int id,mcq_id,mcq_type_id,question_list_id;
    String mcq_question,mcq_marks,mcq_explanation;

    public Mcq(int id, int mcq_id, int mcq_type_id, int question_list_id, String mcq_question, String mcq_marks, String mcq_explanation) {
        this.id = id;
        this.mcq_id = mcq_id;
        this.mcq_type_id = mcq_type_id;
        this.question_list_id = question_list_id;
        this.mcq_question = mcq_question;
        this.mcq_marks = mcq_marks;
        this.mcq_explanation = mcq_explanation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMcq_id() {
        return mcq_id;
    }

    public void setMcq_id(int mcq_id) {
        this.mcq_id = mcq_id;
    }

    public int getMcq_type_id() {
        return mcq_type_id;
    }

    public void setMcq_type_id(int mcq_type_id) {
        this.mcq_type_id = mcq_type_id;
    }

    public int getQuestion_list_id() {
        return question_list_id;
    }

    public void setQuestion_list_id(int question_list_id) {
        this.question_list_id = question_list_id;
    }

    public String getMcq_question() {
        return mcq_question;
    }

    public void setMcq_question(String mcq_question) {
        this.mcq_question = mcq_question;
    }

    public String getMcq_marks() {
        return mcq_marks;
    }

    public void setMcq_marks(String mcq_marks) {
        this.mcq_marks = mcq_marks;
    }

    public String getMcq_explanation() {
        return mcq_explanation;
    }

    public void setMcq_explanation(String mcq_explanation) {
        this.mcq_explanation = mcq_explanation;
    }
}
