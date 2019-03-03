package com.example.speedflatmating;

import android.annotation.SuppressLint;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import static android.support.v4.util.Preconditions.checkArgument;

/**
 *  class holding all methods linking to dates
 */
public class EventDateFormatter {

    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM");
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    private Date start1; // holds venue 1 start date, used for sorting array
    private Date start2; // holds venue 2 start date, used for sorting array

    private TextFormatter textFormatter = new TextFormatter();

    /**
     * @param v to get date of
     * @param textView to set data to
     */
    public void displayDateTime(Venue v, TextView textView) {
        try {

            Date start = formatter.parse(v.getStartTime());
            Date end = formatter.parse(v.getEndTime());
            String timeRunning = sdf.format(start) + " - " + sdf.format(end); //concatinates time string of running
            textView.setText(textFormatter.setMultiLineText(displayRunningDate(start), timeRunning)); //adds date to staty

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param eventDate date to get full text of
     * @return full string with date followed by text and month
     */
    private String displayRunningDate(Date eventDate) {

        int day = eventDate.getDate(); //holds the day event is run on in the month
        return day + getDayOfMonthSuffix(day) +  " " + sdfMonth.format(eventDate); //adds day following text and month
    }

    /**
     *
     * @param day stores the day of the month, used to find the correct text to follow the day
     * @return the suffix for the day
     */
    @SuppressLint("RestrictedApi")
    private String getDayOfMonthSuffix(final int day) {
        checkArgument(day >= 1 && day <= 31, "illegal day of month: " + day);
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }

    /**
     * @param toSort arraylist needed to sort
     * @param upcoming true if upcoming array, false if archiveds
     */
    public void sortArrayListByDate(ArrayList<Venue> toSort, final boolean upcoming) {
        Collections.sort(toSort, new Comparator<Venue>() {
            @Override
            public int compare(Venue o1, Venue o2) {
                if (o1.getStartTime() == null || o2.getStartTime() == null)
                    return 0;

                try {
                    start1 = df.parse(o1.getStartTime());
                    start2 = df.parse(o2.getStartTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if(upcoming) { //if the events have not passed yet
                    // both sort closest to further away, respectively
                    return start1.compareTo(start2);
                } else {
                    return start2.compareTo(start1);
                }
            }
        });
    }
}
