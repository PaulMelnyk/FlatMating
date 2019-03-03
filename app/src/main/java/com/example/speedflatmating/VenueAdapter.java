package com.example.speedflatmating;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueViewHolder> {

    private ArrayList<Venue> dataList; // holds information array to display
    private Context context; //holds application context

    private VenueListViewPopulation listViewPopulation = new VenueListViewPopulation(); // used to hold methods populating listView
    private boolean isExpired; // boolean whether listView is the upcoming or expired

    public VenueAdapter(ArrayList<Venue> dataList, boolean isExpired, Context context) {
        this.dataList = dataList;
        this.isExpired = isExpired;
        this.context = context;
    }
    @NonNull
    @Override
    public VenueAdapter.VenueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.listview_row, viewGroup, false);
        return new VenueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final VenueViewHolder holder, int position) {

        final Venue currentVenueInfo = dataList.get(position); //holds information for correct venue

        listViewPopulation.renderExpiredTag(holder, isExpired); //renders expired overlay if necessary for venue
        listViewPopulation.populateVenue(holder, currentVenueInfo, context); //populate container for venue

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class VenueViewHolder extends RecyclerView.ViewHolder {

        ImageView venueImage;
        TextView priceText, locationText, timeText, expiredText;

        /**
         * @param itemView holds information regarding view
         * sets the items for on screen
         */
        public VenueViewHolder(View itemView) {

            super(itemView);
            venueImage = itemView.findViewById(R.id.venueImage);
            expiredText = itemView.findViewById(R.id.expiredText);

            priceText = itemView.findViewById(R.id.priceText);
            locationText = itemView.findViewById(R.id.locationText);
            timeText = itemView.findViewById(R.id.timeText);
        }
    }
}