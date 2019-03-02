package com.example.speedflatmating;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class VenueListViewPopulator {
    private EventDateFormatter eventDateFormatter = new EventDateFormatter();
    private TextFormatter textFormatter = new TextFormatter();

    public void populateVenue(VenueAdapter.VenueViewHolder holder, Venue currentVenueInfo, Context context) {
        Picasso.get().load(currentVenueInfo.getImageUrl()).fit().centerCrop().into(holder.venueImage);

        holder.priceText.setText(textFormatter.capitalizeFirst(currentVenueInfo.getCost()));
        holder.locationText.setText(textFormatter.setMultiLineText(currentVenueInfo.getLocation(), currentVenueInfo.getVenue()));
        eventDateFormatter.displayDateTime(currentVenueInfo, holder.timeText);

        setImageClick(holder.venueImage, context);
    }

    public void dialIntent(Context context) {
        String phone = "+34666777888";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private void setImageClick(final ImageView imageView, final Context context) {
        imageView.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialIntent(context);
            }
        });
    }
}
