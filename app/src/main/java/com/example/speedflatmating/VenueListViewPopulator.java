package com.example.speedflatmating;

import com.squareup.picasso.Picasso;

public class VenueListViewPopulator {
    private EventDateFormatter eventDateFormatter = new EventDateFormatter();
    private TextFormatter textFormatter = new TextFormatter();

    public void test(VenueAdapter.VenueViewHolder holder, Venue currentVenueInfo) {
        Picasso.get().load(currentVenueInfo.getImageUrl()).fit().centerCrop().into(holder.venueImage);

        holder.priceText.setText(currentVenueInfo.getCost());
        holder.locationText.setText(textFormatter.setMultiLineText(currentVenueInfo.getLocation(), currentVenueInfo.getVenue()));
        eventDateFormatter.displayDateTime(currentVenueInfo, holder.timeText);
    }
}
