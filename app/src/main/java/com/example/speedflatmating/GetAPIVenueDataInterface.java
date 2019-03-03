package com.example.speedflatmating;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * collect data from api call
 */
public interface GetAPIVenueDataInterface {

    @GET("b/5c6a9becf73bfe1ce3ed01bf/")
    Call<List<Venue>> getAPIVenueData();

}
