package com.vedmitryapps.githubsearch.model.api;


import com.vedmitryapps.githubsearch.model.data.GitResponse;
import com.vedmitryapps.githubsearch.model.data.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("users/{user}/repos")
    Call<List<Repo>> getRepositories(@Path("user") String user);

    @GET("search/users")
    Call<GitResponse> getUsers(@Query("q") String q);

}
