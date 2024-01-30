package com.ltrsoft.ltrjob.pojoclass;

public class Placement {

    private int placement_id,user_id,job_id,id;
    private String date_placed,placemet_role,placement_package,placed_through_ltr;

    public Placement(int placement_id, int user_id, int job_id, int id, String date_placed, String placemet_role, String placement_package, String placed_through_ltr) {
        this.placement_id = placement_id;
        this.user_id = user_id;
        this.job_id = job_id;
        this.id = id;

    }

    public Placement(String datePlaced, String placemetRole, String placementPackage, String placedThroughLtr) {
        this.date_placed = datePlaced;
        this.placemet_role = placemetRole;
        this.placement_package = placementPackage;
        this.placed_through_ltr = placedThroughLtr;

    }


    public int getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(int placement_id) {
        this.placement_id = placement_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_placed() {
        return date_placed;
    }

    public void setDate_placed(String date_placed) {
        this.date_placed = date_placed;
    }

    public String getPlacemet_role() {
        return placemet_role;
    }

    public void setPlacemet_role(String placemet_role) {
        this.placemet_role = placemet_role;
    }

    public String getPlacement_package() {
        return placement_package;
    }

    public void setPlacement_package(String placement_package) {
        this.placement_package = placement_package;
    }

    public String getPlaced_through_ltr() {
        return placed_through_ltr;
    }

    public void setPlaced_through_ltr(String placed_through_ltr) {
        this.placed_through_ltr = placed_through_ltr;
    }
}
