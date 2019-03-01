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

    @SerializedName("cost")
    private String cost;

    @SerializedName("startDate")
    private Date startDate;

    @SerializedName("endDate")
    private Date endDate;

    public Venue() {}

    public Venue(String imageUrl, String location, String venue, String cost, Date startDate, Date endDate) {
        this.imageUrl = imageUrl;
        this.location = location;
        this.venue = venue;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "imageUrl='" + imageUrl + '\'' +
                ", location='" + location + '\'' +
                ", venue='" + venue + '\'' +
                ", cost='" + cost + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
