package com.ltrsoft.ltrjob.pojoclass;

public class Notification_Photo {
    private int notifiction_photo_id,notification_id;
    private String notification_photo_path;

    public Notification_Photo(int notifiction_photo_id, int notification_id, String notification_photo_path) {
        this.notifiction_photo_id = notifiction_photo_id;
        this.notification_id = notification_id;
        this.notification_photo_path = notification_photo_path;
    }

    public int getNotifiction_photo_id() {
        return notifiction_photo_id;
    }

    public void setNotifiction_photo_id(int notifiction_photo_id) {
        this.notifiction_photo_id = notifiction_photo_id;
    }

    public int getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(int notification_id) {
        this.notification_id = notification_id;
    }

    public String getNotification_photo_path() {
        return notification_photo_path;
    }

    public void setNotification_photo_path(String notification_photo_path) {
        this.notification_photo_path = notification_photo_path;
    }
}
