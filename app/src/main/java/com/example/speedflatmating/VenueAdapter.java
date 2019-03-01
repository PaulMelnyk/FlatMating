package com.example.speedflatmating;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueViewHolder> {

    private ArrayList<Venue> dataList;
    private EventDateFormatter eventDateFormatter = new EventDateFormatter();


    public VenueAdapter(ArrayList<Venue> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public VenueAdapter.VenueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.listview_row, viewGroup, false);
        return new VenueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VenueAdapter.VenueViewHolder holder, int position) {
        final Venue currentVenueInfo = dataList.get(position);

        Picasso.get().load(currentVenueInfo.getImageUrl()).fit().centerCrop().into(holder.venueImage);
        holder.priceText.setText(currentVenueInfo.getCost());
        holder.locationText.setText(currentVenueInfo.getLocation() + "\n" + currentVenueInfo.getVenue());
        holder.timeText.setText(eventDateFormatter.displayDateTime(currentVenueInfo));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class VenueViewHolder extends RecyclerView.ViewHolder {

        ImageView venueImage;
        TextView priceText, locationText, timeText;


        public VenueViewHolder(View itemView) {
            super(itemView);
            venueImage = itemView.findViewById(R.id.venueImage);

            priceText = itemView.findViewById(R.id.priceText);
            locationText = itemView.findViewById(R.id.locationText);
            timeText = itemView.findViewById(R.id.timeText);
        }
    }
}
