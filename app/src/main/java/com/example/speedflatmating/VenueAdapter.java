package com.example.speedflatmating;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueViewHolder>{

    private ArrayList<Venue> dataList;

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
    public void onBindViewHolder(@NonNull VenueAdapter.VenueViewHolder venueViewHolder, int position) {
        venueViewHolder.testingTextView.setText(dataList.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class VenueViewHolder extends RecyclerView.ViewHolder {

        TextView testingTextView;

        VenueViewHolder(View itemView) {
            super(itemView);
            testingTextView =  itemView.findViewById(R.id.textView);
        }

    }
}
