package com.vedmitryapps.githubsearch.view;


import com.vedmitryapps.githubsearch.model.data.Repo;
import com.vedmitryapps.githubsearch.model.data.User;

import java.util.List;

public interface View {

    void showData(List<Repo> list);

    void showUsers(List<User> list);

    void showError(String error);

    void showEmptyList();

    String getUserName();
}
