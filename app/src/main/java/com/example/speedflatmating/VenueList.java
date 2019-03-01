package com.example.speedflatmating;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VenueList {

    @SerializedName("venueList")
    private ArrayList<Venue> venueList;

    public ArrayList<Venue> getVenueList() {
        return venueList;
    }

    public void setVenueList(ArrayList<Venue> venueArrayList) {
        this.venueList = venueArrayList;
    }

}
