package com.vedmitryapps.githubsearch.model.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiModule {

    public static ApiInterface getApiInterface() {

        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        ApiInterface apiInterface = builder.build().create(ApiInterface.class);
        return apiInterface;
    }
}
