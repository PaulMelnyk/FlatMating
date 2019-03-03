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

/**
 *  used to display screen information
 */
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

    /**
     * @param venueArrayList holds venues for upcoming or archieved depending on button clicked
     * renders the listview on screen with custom layout
     */
    private void generateVenueList(ArrayList<Venue> venueArrayList) {
        recyclerView = activity.findViewById(R.id.recycler_view_venue_list);
        adapter = new VenueAdapter(venueArrayList, isExpired, context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    /**
     * @param venueArrayList to display
     * sorts the arraylists into upcoming and passed depending on their date in relation to the current date
     */
    private void checkVenueListDate(ArrayList<Venue> venueArrayList) {
        for(Venue currentVenue: venueArrayList) { // loops all input venues
            try {
                Date dateOfEvent = formatter.parse(currentVenue.getStartTime());
                if(dateOfEvent.before(currentDate)) { //compares the date to current
                    eventPassed.add(currentVenue); //if date of event before current adds into passed array
                } else { //otherwise adds to the upcoming
                    eventUpcoming.add(currentVenue);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // sort the arrays on their dates to display
        eventDateFormatter.sortArrayListByDate(eventPassed, false);
        eventDateFormatter.sortArrayListByDate(eventUpcoming, true);
    }

    /**
     * @param button to set
     * set button click data to button
     */
    private void setButtonClick(final Button button) {
        button.setOnClickListener( new View.OnClickListener() {

            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                switch (v.getId()) { // gets the id of the button
                    case R.id.button_upcoming: //if upcoming clicked
                        isExpired = false; //passed to the venueAdapter to render correct display
                        setScreen(eventUpcoming, upcomingButton, archivedButton);
                        break;
                    case R.id.button_archived: // if passed clicked
                        isExpired = true; //passed to the venueAdapter to render correct display
                        setScreen(eventPassed, archivedButton, upcomingButton);
                        break;
                }
            }
        });
    }

    /**
     * @param args collects all buttons
     * collects buttons to set the click data, instead of manually inputting each time
     */
    private void loopingSet(Button... args) {
        for(Button currentButton : args) {
            setButtonClick(currentButton);
        }
    }

    /**
     * @param allVenues holds every venue returned
     * @param activity the on screen view to change
     * @param context holds application context
     * Method is used from the main activity, to display the necessary information on screen
     */
    public void compileDisplay (ArrayList<Venue> allVenues, Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
        setButtons();
        loopingSet(upcomingButton, archivedButton);
        allVenues.addAll(testCaseNewEvents.createUpcomingEvents(allVenues.get(0))); //testing to generate later events

        checkVenueListDate(allVenues); // generates 2 arraylists
        setScreen(eventUpcoming, upcomingButton, archivedButton);
    }

    /**
     * finds the buttons on screen and assigns
     */
    private void setButtons() {
        upcomingButton = activity.findViewById(R.id.button_upcoming);
        archivedButton = activity.findViewById(R.id.button_archived);
    }

    /**
     * @param eventsOnOpen which list we are trying to render
     * @param mainButton button being pressed
     * @param secondaryButton button depressed currently
     */
    private void setScreen(ArrayList<Venue> eventsOnOpen, Button mainButton, Button secondaryButton) {
        generateVenueList(eventsOnOpen);
        buttonColors(mainButton, secondaryButton);
    }

    /**
     * @param pressed button pressed by user
     * @param inactive button currently depressed to alter
     */
    private void buttonColors(Button pressed, Button inactive) {
        pressed.setBackgroundColor(activity.getResources().getColor(R.color.colorPrimaryDark));
        inactive.setBackgroundColor(activity.getResources().getColor(R.color.colorPrimary));
    }
}
