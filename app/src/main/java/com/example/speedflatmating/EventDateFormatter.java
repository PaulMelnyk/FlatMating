package com.example.speedflatmating;

import android.annotation.SuppressLint;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import static android.support.v4.util.Preconditions.checkArgument;

public class EventDateFormatter {

    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    private Date start1;
    private Date start2;

    private TextFormatter textFormatter = new TextFormatter();

    public void displayDateTime(Venue v, TextView textView) {
        try {

            Date start = formatter.parse(v.getStartTime());
            Date end = formatter.parse(v.getEndTime());
            String timeRunning = sdf.format(start) + " - " + sdf.format(end);
            textView.setText(textFormatter.setMultiLineText(displayRunningDate(start), timeRunning));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String displayRunningDate(Date eventDate) {

        int t = eventDate.getDate();
        return t + getDayOfMonthSuffix(t) +  " " + sdfMonth.format(eventDate);
    }

    @SuppressLint("RestrictedApi")
    private String getDayOfMonthSuffix(final int n) {
        checkArgument(n >= 1 && n <= 31, "illegal day of month: " + n);
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }

    public void sortArrayList(ArrayList<Venue> toSort, final boolean upcoming) {
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

                if(upcoming) {
                    return start1.compareTo(start2);
                } else {
                    return start2.compareTo(start1);
                }
            }
        });
    }
}
