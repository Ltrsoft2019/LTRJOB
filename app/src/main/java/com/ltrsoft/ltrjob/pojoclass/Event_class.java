package com.ltrsoft.ltrjob.pojoclass;

public class Event_class {
     String  eventid,event_name, event_description, event_guest, event_venue, event_date_time, event_duration, photo_path, event_type_name;

    public Event_class(String event_name, String eventid, String event_description, String event_guest, String event_venue, String event_date_time, String event_duration, String photo_path, String description, String s) {
        this.event_name = event_name;
        this.event_description = event_description;
        this.event_guest = event_guest;
        this.event_venue = event_venue;
        this.event_date_time = event_date_time;
        this.event_duration = event_duration;
        this.photo_path = photo_path;
        this.eventid = eventid;

        this.event_type_name = event_type_name;
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

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public String getEvent_type_name() {
        return event_type_name;
    }

    public void setEvent_type_name(String event_type_name) {
        this.event_type_name = event_type_name;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }
}
