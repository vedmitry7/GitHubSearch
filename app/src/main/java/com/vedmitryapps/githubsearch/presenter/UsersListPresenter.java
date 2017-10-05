package com.vedmitryapps.githubsearch.presenter;


import android.util.Log;

import com.vedmitryapps.githubsearch.model.Model;
import com.vedmitryapps.githubsearch.model.ModelImpl;
import com.vedmitryapps.githubsearch.model.data.GitResponse;
import com.vedmitryapps.githubsearch.model.data.User;
import com.vedmitryapps.githubsearch.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersListPresenter implements UserListPresenterInterface {

    private View view;
    private Model model = new ModelImpl();

    public UsersListPresenter(View view) {
        this.view = view;
    }

    @Override
    public void onSearchButtonClick() {
        model.getUsers(view.getUserName()).enqueue(new Callback<GitResponse>() {
            @Override
            public void onResponse(Call<GitResponse> call, Response<GitResponse> response) {
                Log.i("TAG22", "response");
                if(!response.isSuccessful()){
                    view.showEmptyList();
                    Log.i("TAG22", "Not Successful");
                    return;
                } else {
                    Log.i("TAG22", "Successful");
                }
                Log.i("TAG22", String.valueOf(response.isSuccessful()));
                Log.i("TAG22", String.valueOf(response.body().getItems()==null));


                view.showUsers(response.body().getItems());

                for (User u:response.body().getItems()
                     ) {
                    Log.i("TAG22", u.getLogin());
                }
            }

            @Override
            public void onFailure(Call<GitResponse> call, Throwable t) {
                Log.i("TAG22", "response Failure");
                view.showError(t.getMessage());
            }
        });
    }

    @Override
    public void onNextSearch() {

    }

    @Override
    public void onStop() {

    }
}
