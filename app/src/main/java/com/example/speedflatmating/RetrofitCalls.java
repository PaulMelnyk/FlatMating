package com.example.speedflatmating;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCalls {

    private static Retrofit retrofit;
    private static final String URL = "https://api.jsonbin.io/b/5c6a9becf73bfe1ce3ed01bf";

    public static Retrofit getRetrofit() {
        if(retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
