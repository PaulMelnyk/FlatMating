package com.example.speedflatmating;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * class used for populating the items within the repeating list view
 */
public class VenueListViewPopulation {
    private EventDateFormatter eventDateFormatter = new EventDateFormatter();
    private TextFormatter textFormatter = new TextFormatter();

    /**
     * @param holder current instance of repeating view to populate
     * @param currentVenueInfo venue to display
     * @param context application context
     */
    public void populateVenue(VenueAdapter.VenueViewHolder holder, Venue currentVenueInfo, Context context) {
        Picasso.get().load(currentVenueInfo.getImageUrl()).fit().centerCrop().into(holder.venueImage); // gather image

        holder.priceText.setText(textFormatter.capitalizeFirst(currentVenueInfo.getCost())); //set text of price to capitalized string
        holder.locationText.setText(textFormatter.setMultiLineText(currentVenueInfo.getLocation(), currentVenueInfo.getVenue())); //sets location across 2 lines
        eventDateFormatter.displayDateTime(currentVenueInfo, holder.timeText); //sets event time

        setImageClick(holder.venueImage, context); //adds image on click method
    }

    /**
     * @param context application context
     * used to open phone, input number supplied
     */
    public void dialIntent(Context context) {
        String phone = "01617681162";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null)); //creates intent to dial
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent); // applies the intent
    }

    /**
     * @param imageView to set click on
     * @param context application context
     */
    private void setImageClick(final ImageView imageView, final Context context) {
        imageView.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialIntent(context); //dials when clicked
            }
        });
    }


    /**
     * @param holder current instance of repeating view
     * @param isExpired boolean true if the list is expired events
     */
    public void renderExpiredTag(VenueAdapter.VenueViewHolder holder, boolean isExpired) {
        if(isExpired) { //if expired
            holder.expiredText.setVisibility(View.VISIBLE); //shows tag
        } else { //if upcoming
            holder.expiredText.setVisibility(View.INVISIBLE); //hides tag
        }
    }
}
