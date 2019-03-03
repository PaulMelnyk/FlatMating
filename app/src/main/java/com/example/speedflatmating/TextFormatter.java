package com.example.speedflatmating;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;

/**
 * class used for formatting text on screen
 */
public class TextFormatter {

    private final StyleSpan bold = new StyleSpan(android.graphics.Typeface.BOLD); // formatting for bold text
    final StyleSpan normal = new StyleSpan(Typeface.NORMAL); //Span to make text italic

    /**
     * @param toFormat string to alter
     * @return complete string, with the first line in bold
     */
    private SpannableStringBuilder boldFormatter(String toFormat) {
        int findBreak = toFormat.indexOf("\n"); // finds int of the line break
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(toFormat);

        spannableStringBuilder.setSpan(bold, 0, findBreak, Spanned.SPAN_INCLUSIVE_EXCLUSIVE); //sets bold before break
        spannableStringBuilder.setSpan(normal, findBreak+1, spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE); // sets normal after break

        return spannableStringBuilder; //returns string completed
    }

    /**
     * @param first string before break
     * @param second string after break
     * @return complete string with break between
     */
    private String concatenateStrings(String first, String second) {
        return first + "\n" + second;
    }

    /**
     * @param first
     * @param second
     * @return public access, bold and concatinated string, used for location and date
     */
    public SpannableStringBuilder setMultiLineText(String first, String second) {
        return boldFormatter(concatenateStrings(first, second));
    }

    /**
     * @param toCap string for formatting
     * @return string with capitalized first, used for pricing
     */
    public String capitalizeFirst(String toCap) {
        StringBuilder stringBuilder = new StringBuilder(toCap);
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));

        return String.valueOf(stringBuilder);
    }
}
