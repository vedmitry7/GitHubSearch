package com.vedmitryapps.githubsearch.model;


import com.vedmitryapps.githubsearch.model.data.GitResponse;
import com.vedmitryapps.githubsearch.model.data.Repo;

import java.util.List;

import retrofit2.Call;

public interface Model {

    Call<List<Repo>> getRepositories(String user);

    Call<GitResponse> getUsers(String q);
}
