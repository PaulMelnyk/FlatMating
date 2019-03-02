package com.example.speedflatmating;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TESTCaseNewEvents {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public ArrayList<Venue> createUpcomingEvents(Venue v) throws ParseException {
        ArrayList<Venue> newEvents = new ArrayList<>();

        for (int i = 10; i< 15; i++) {
            Venue newVenue = new Venue();
            newVenue.setImageUrl(v.getImageUrl());
            newVenue.setLocation("Location " + i);
            newVenue.setVenue("Venue " + i);
            newVenue.setCost("Free");
            newVenue.setStartTime("2019-03-0" + i + " 05:00:00");
            newVenue.setEndTime("2019-03-0" + i + " 08:00:00");

            newEvents.add(newVenue);
        }

        return newEvents;
    }
}
