package com.ltrsoft.ltrjob.pojoclass;

public class Event {
    private int id,event_id,event_type_id;
    private String event_name,event_description,event_guest,event_venue,event_date_time,event_duration;

    public Event(int id, int event_id, int event_type_id, String event_name, String event_description, String event_guest, String event_venue, String event_date_time, String event_duration) {
        this.id = id;
        this.event_id = event_id;
        this.event_type_id = event_type_id;
        this.event_name = event_name;
        this.event_description = event_description;
        this.event_guest = event_guest;
        this.event_venue = event_venue;
        this.event_date_time = event_date_time;
        this.event_duration = event_duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getEvent_type_id() {
        return event_type_id;
    }

    public void setEvent_type_id(int event_type_id) {
        this.event_type_id = event_type_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public String getEvent_guest() {
        return event_guest;
    }

    public void setEvent_guest(String event_guest) {
        this.event_guest = event_guest;
    }

    public String getEvent_venue() {
        return event_venue;
    }

    public void setEvent_venue(String event_venue) {
        this.event_venue = event_venue;
    }

    public String getEvent_date_time() {
        return event_date_time;
    }

    public void setEvent_date_time(String event_date_time) {
        this.event_date_time = event_date_time;
    }

    public String getEvent_duration() {
        return event_duration;
    }

    public void setEvent_duration(String event_duration) {
        this.event_duration = event_duration;
    }
}
