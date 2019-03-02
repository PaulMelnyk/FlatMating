package com.example.speedflatmating;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;

public class TextFormatter {

    private final StyleSpan bold = new StyleSpan(android.graphics.Typeface.BOLD); // formatting for bold text
    final StyleSpan normal = new StyleSpan(Typeface.NORMAL); //Span to make text italic

    public SpannableStringBuilder boldFormatter(String toFormat) {
        int findBreak = toFormat.indexOf("\n");
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(toFormat);

        spannableStringBuilder.setSpan(bold, 0, findBreak, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(normal, findBreak+1, spannableStringBuilder.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        return spannableStringBuilder;
    }

    private String concatinateStrings(String first, String second) {
        return first + "\n" + second;
    }

    public SpannableStringBuilder setMultiLineText(String first, String second) {

        return boldFormatter(concatinateStrings(first, second));
    }

    public String capitalizeFirst(String toCap) {
        StringBuilder stringBuilder = new StringBuilder(toCap);
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));

        return String.valueOf(stringBuilder);
    }
}
