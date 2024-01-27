package com.ltrsoft.ltrjob.pojoclass;

public class Notification_User {

    private int id,notification_user_id,notification_id,user_id;

    public Notification_User(int id, int notification_user_id, int notification_id, int user_id) {
        this.id = id;
        this.notification_user_id = notification_user_id;
        this.notification_id = notification_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNotification_user_id() {
        return notification_user_id;
    }

    public void setNotification_user_id(int notification_user_id) {
        this.notification_user_id = notification_user_id;
    }

    public int getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(int notification_id) {
        this.notification_id = notification_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
