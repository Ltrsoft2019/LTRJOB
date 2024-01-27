package com.ltrsoft.ltrjob.pojoclass;

public class Notification {
    private int notification_id,id,user_id;
    private String notification_description,notification_subject,notifiaction_date;

    public Notification(int notification_id, int id, int user_id, String notification_description, String notification_subject, String notifiaction_date) {
        this.notification_id = notification_id;
        this.id = id;
        this.user_id = user_id;
        this.notification_description = notification_description;
        this.notification_subject = notification_subject;
        this.notifiaction_date = notifiaction_date;
    }

    public int getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(int notification_id) {
        this.notification_id = notification_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNotification_description() {
        return notification_description;
    }

    public void setNotification_description(String notification_description) {
        this.notification_description = notification_description;
    }

    public String getNotification_subject() {
        return notification_subject;
    }

    public void setNotification_subject(String notification_subject) {
        this.notification_subject = notification_subject;
    }

    public String getNotifiaction_date() {
        return notifiaction_date;
    }

    public void setNotifiaction_date(String notifiaction_date) {
        this.notifiaction_date = notifiaction_date;
    }
}
