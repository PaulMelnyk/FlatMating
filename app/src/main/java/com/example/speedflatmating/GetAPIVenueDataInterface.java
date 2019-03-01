package com.example.speedflatmating;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetAPIVenueDataInterface {

    @GET()
    Call<VenueList> getAPIVenueData();

    @GET("group/{imageUrl}/users")
    Call<List<Venue>> groupList(@Path("imageUrl") String groupImage);

}
