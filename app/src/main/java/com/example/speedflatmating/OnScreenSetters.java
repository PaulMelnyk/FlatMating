package com.example.speedflatmating;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OnScreenSetters {

    private Activity activity;

    private VenueAdapter adapter;
    private RecyclerView recyclerView;
    private Context context;

    private boolean isExpired = false;

    private ArrayList<Venue> eventPassed = new ArrayList<>();
    private ArrayList<Venue> eventUpcoming = new ArrayList<>();

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private TESTCaseNewEvents testCaseNewEvents = new TESTCaseNewEvents();
    private EventDateFormatter eventDateFormatter = new EventDateFormatter();

    private Date currentDate = new Date();

    private Button upcomingButton, archivedButton;

    /** Method to generate List of notice using RecyclerView with custom adapter*/
    private void generateVenueList(ArrayList<Venue> venueArrayList) {
        recyclerView = activity.findViewById(R.id.recycler_view_venue_list);
        adapter = new VenueAdapter(venueArrayList, isExpired, context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void checkVenueListDate(ArrayList<Venue> venueArrayList) {
        for(Venue currentVenue: venueArrayList) {
            try {
                Date dateOfEvent = formatter.parse(currentVenue.getStartTime());
                if(dateOfEvent.before(currentDate)) {
                    eventPassed.add(currentVenue);
                } else {
                    eventUpcoming.add(currentVenue);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        eventDateFormatter.sortArrayList(eventPassed, false);
        eventDateFormatter.sortArrayList(eventUpcoming, true);
    }

    private void setButtonClick(final Button button) {
        button.setOnClickListener( new View.OnClickListener() {

            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_upcoming:
                        isExpired = false;
                        setScreen(eventUpcoming, upcomingButton, archivedButton);
                        break;
                    case R.id.button_archived:
                        isExpired = true;
                        setScreen(eventPassed, archivedButton, upcomingButton);
                        break;
                }
            }
        });
    }

    public void loopingSet(Button... args) {
        for(Button currentButton : args) {
            setButtonClick(currentButton);
        }
    }

    public void test (ArrayList<Venue> allVenues, Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
        setButtons();
        loopingSet(upcomingButton, archivedButton);

        try {
            allVenues.addAll(testCaseNewEvents.createUpcomingEvents(allVenues.get(0)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        checkVenueListDate(allVenues); // generates 2 arraylists
        setScreen(eventUpcoming, upcomingButton, archivedButton);
    }

    public void setButtons() {
        upcomingButton = activity.findViewById(R.id.button_upcoming);
        archivedButton = activity.findViewById(R.id.button_archived);
    }

    public void setScreen(ArrayList<Venue> eventsOnOpen, Button mainButton, Button secondaryButton) {
        generateVenueList(eventsOnOpen);
        buttonColors(mainButton, secondaryButton);
    }

    private void buttonColors(Button pressed, Button inactive) {
        pressed.setBackgroundColor(activity.getResources().getColor(R.color.colorPrimaryDark));
        inactive.setBackgroundColor(activity.getResources().getColor(R.color.colorPrimary));
    }
}
