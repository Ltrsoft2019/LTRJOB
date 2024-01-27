package com.ltrsoft.ltrjob.pojoclass;

public class Event_photo {
    private int id,event_photo_id,event_id;
    private String photo_path;

    public Event_photo(int id, int event_photo_id, int event_id, String photo_path) {
        this.id = id;
        this.event_photo_id = event_photo_id;
        this.event_id = event_id;
        this.photo_path = photo_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvent_photo_id() {
        return event_photo_id;
    }

    public void setEvent_photo_id(int event_photo_id) {
        this.event_photo_id = event_photo_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }
}
