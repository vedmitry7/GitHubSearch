package com.vedmitryapps.githubsearch.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vedmitryapps.githubsearch.R;
import com.vedmitryapps.githubsearch.model.data.Repo;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Repo> repoList = new ArrayList<>();

    public void setRepoList(List<Repo> repoList) {
        this.repoList = repoList;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repo_layout, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Repo Repo = repoList.get(i);
        viewHolder.name.setText(Repo.getName());
    }

    @Override
    public int getItemCount() {
        if(repoList == null)
            repoList = new ArrayList<>();

        return repoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}