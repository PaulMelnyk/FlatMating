package com.example.speedflatmating;

import android.annotation.SuppressLint;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.support.v4.util.Preconditions.checkArgument;

public class EventDateFormatter {

    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

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
}
