package com.example.speedflatmating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private VenueAdapter adapter;
    private RecyclerView recyclerView;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private Date currentDate = new Date();

    private ArrayList<Venue> eventPassed = new ArrayList<>();
    private ArrayList<Venue> eventUpcoming = new ArrayList<>();

    private Button upcomingButton, archivedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upcomingButton = findViewById(R.id.button_upcoming);
        archivedButton = findViewById(R.id.button_archived);

        loopingSet(upcomingButton, archivedButton);

        /** Create handle for the RetrofitInstance interface*/
        GetAPIVenueDataInterface service = RetrofitCalls.getRetrofit().create(GetAPIVenueDataInterface.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<List<Venue>> call = service.getAPIVenueData();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<List<Venue>>() {
            @Override
            public void onResponse(Call<List<Venue>> call, Response<List<Venue>> response) {
                checkVenueListDate((ArrayList<Venue>) response.body()); // generates 2 arraylists
  //              generateVenueList((ArrayList<Venue>) response.body());
                upcomingButton.setSelected(true);
            }

            @Override
            public void onFailure(Call<List<Venue>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Error: " + t.getMessage());
            }
        });
    }

    /** Method to generate List of notice using RecyclerView with custom adapter*/
    private void generateVenueList(ArrayList<Venue> venueArrayList) {
        recyclerView = findViewById(R.id.recycler_view_venue_list);
        adapter = new VenueAdapter(venueArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void checkVenueListDate(ArrayList<Venue> venueArrayList) {
        for(Venue currentVenue: venueArrayList) {
            try {
                Date dateOfEvent = formatter.parse(currentVenue.getStartTime());
                if(dateOfEvent.before(currentDate)) {
                    eventPassed.add(currentVenue);
                } else {
                    eventUpcoming.add(currentVenue);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private void setButtonClick(Button button) {
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_upcoming:
                        generateVenueList(eventUpcoming);
                        break;
                    case R.id.button_archived:
                        generateVenueList(eventPassed);
                        break;
                }
            }
        });
    }

    private void loopingSet(Button... args) {
        for(Button currentButton : args) {
            setButtonClick(currentButton);
        }
    }

}
