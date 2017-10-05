package com.vedmitryapps.githubsearch.model;

import com.vedmitryapps.githubsearch.model.api.ApiInterface;
import com.vedmitryapps.githubsearch.model.api.ApiModule;
import com.vedmitryapps.githubsearch.model.data.GitResponse;
import com.vedmitryapps.githubsearch.model.data.Repo;

import java.util.List;

import retrofit2.Call;


public class ModelImpl implements Model {

    ApiInterface apiInterface = ApiModule.getApiInterface();

    @Override
    public Call<List<Repo>> getRepositories(String user) {
        return apiInterface.getRepositories(user);
    }

    @Override
    public Call<GitResponse> getUsers(String q) {
        return apiInterface.getUsers(q);
    }

}
