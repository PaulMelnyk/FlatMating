package com.example.speedflatmating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private OnScreenSetters onScreenSetters = new OnScreenSetters();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Create handle for the RetrofitInstance interface*/
        GetAPIVenueDataInterface service = RetrofitCalls.getRetrofit().create(GetAPIVenueDataInterface.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<List<Venue>> call = service.getAPIVenueData();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<List<Venue>>() {
            @Override
            public void onResponse(Call<List<Venue>> call, Response<List<Venue>> response) {
                ArrayList<Venue> allVenues = (ArrayList<Venue>) response.body();

                onScreenSetters.test(allVenues, MainActivity.this, getApplication());
            }

            @Override
            public void onFailure(Call<List<Venue>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Error: " + t.getMessage());
            }
        });
    }
}
