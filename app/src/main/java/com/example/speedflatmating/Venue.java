package com.example.speedflatmating;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Venue {

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("location")
    private String location;

    @SerializedName("venue")
    private String venue;

    @SerializedName("startTime")
    private String startTime;

    @SerializedName("endTime")
    private String endTime;

    @SerializedName("cost")
    private String cost;

    public Venue() {}

    public Venue(String imageUrl, String location, String venue, String startTime, String endTime, String cost) {
        this.imageUrl = imageUrl;
        this.location = location;
        this.venue = venue;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "imageUrl='" + imageUrl + '\'' +
                ", location='" + location + '\'' +
                ", venue='" + venue + '\'' +
                ", startDate=" + startTime +
                ", endDate=" + endTime +
                ", cost='" + cost + '\'' +
                '}';
    }
}
