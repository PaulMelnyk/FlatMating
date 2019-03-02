package com.example.speedflatmating;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static android.support.v4.util.Preconditions.checkArgument;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueViewHolder> {

    private ArrayList<Venue> dataList;
    private EventDateFormatter eventDateFormatter = new EventDateFormatter();
    private VenueListViewPopulator listViewPopulator = new VenueListViewPopulator();

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
    public void onBindViewHolder(final VenueViewHolder holder, int position) {
        final Venue currentVenueInfo = dataList.get(position);
        listViewPopulator.test(holder, currentVenueInfo);
    }


    @Override
    public int getItemCount() {
        return dataList.size();
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