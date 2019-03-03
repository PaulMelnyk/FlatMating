package com.example.speedflatmating;

import java.util.ArrayList;

/**
 *  testing cases for venues with upcoming dates
 */
public class TESTCaseNewEvents {

    /**
     * @param v used to replicate imge
     * @return full arraylist of new venues, with later dates
     */
    public ArrayList<Venue> createUpcomingEvents(Venue v) {
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
