package com.vedmitryapps.githubsearch.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.vedmitryapps.githubsearch.R;
import com.vedmitryapps.githubsearch.model.data.Repo;
import com.vedmitryapps.githubsearch.model.data.User;
import com.vedmitryapps.githubsearch.presenter.UserListPresenterInterface;
import com.vedmitryapps.githubsearch.presenter.UsersListPresenter;
import com.vedmitryapps.githubsearch.view.adapters.RecyclerViewUserAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View {


    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.editText)
    EditText editText;

    @Bind(R.id.button)
    Button searchButton;

    private RecyclerViewUserAdapter adapter;
    private UserListPresenterInterface userListPresenterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        userListPresenterInterface = new UsersListPresenter(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        adapter = new RecyclerViewUserAdapter();
        recyclerView.setAdapter(adapter);

        searchButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                userListPresenterInterface.onSearchButtonClick();
            }
        });


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i("TAG22", String.valueOf(editable));
                if(editable.length()>2){
                    userListPresenterInterface.onSearchButtonClick();
                }
            }
        });
    }

    @Override
    public void showData(List<Repo> list) {
        //  adapter.setRepoList(list);
    }

    @Override
    public void showUsers(List<User> list) {
        adapter.setRepoList(list);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (userListPresenterInterface != null) {
            userListPresenterInterface.onStop();
        }
    }

    private void makeToast(String text) {
        Snackbar.make(toolbar, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(String error) {
        makeToast(error);
    }

    @Override
    public void showEmptyList() {
        makeToast("empty repo list");
    }

    @Override
    public String getUserName() {
        return editText.getText().toString();
    }
}
