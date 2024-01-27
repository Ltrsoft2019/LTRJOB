package com.ltrsoft.ltrjob.pojoclass;

public class True_False {
    private int true_false_id,id,question_list_id;
    private String true_false_question,true_false_correct_answer,true_false_marks,true_false_explanation;

    public True_False(int true_false_id, int id, int question_list_id, String true_false_question, String true_false_correct_answer, String true_false_marks, String true_false_explanation) {
        this.true_false_id = true_false_id;
        this.id = id;
        this.question_list_id = question_list_id;
        this.true_false_question = true_false_question;
        this.true_false_correct_answer = true_false_correct_answer;
        this.true_false_marks = true_false_marks;
        this.true_false_explanation = true_false_explanation;
    }

    public int getTrue_false_id() {
        return true_false_id;
    }

    public void setTrue_false_id(int true_false_id) {
        this.true_false_id = true_false_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion_list_id() {
        return question_list_id;
    }

    public void setQuestion_list_id(int question_list_id) {
        this.question_list_id = question_list_id;
    }

    public String getTrue_false_question() {
        return true_false_question;
    }

    public void setTrue_false_question(String true_false_question) {
        this.true_false_question = true_false_question;
    }

    public String getTrue_false_correct_answer() {
        return true_false_correct_answer;
    }

    public void setTrue_false_correct_answer(String true_false_correct_answer) {
        this.true_false_correct_answer = true_false_correct_answer;
    }

    public String getTrue_false_marks() {
        return true_false_marks;
    }

    public void setTrue_false_marks(String true_false_marks) {
        this.true_false_marks = true_false_marks;
    }

    public String getTrue_false_explanation() {
        return true_false_explanation;
    }

    public void setTrue_false_explanation(String true_false_explanation) {
        this.true_false_explanation = true_false_explanation;
    }
}
