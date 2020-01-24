package com.puretech.daggerexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.puretech.daggerexample.R;
import com.puretech.daggerexample.model.MovieData;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyMovieHolder> {

    List<MovieData> dataList;
    Context context;

    public MovieAdapter(List<MovieData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyMovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_list_item, parent, false);
        return new MovieAdapter.MyMovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMovieHolder holder, int position) {

        holder.txtMovieName.setText("" + dataList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyMovieHolder extends RecyclerView.ViewHolder {
        TextView txtMovieName;

        public MyMovieHolder(@NonNull View itemView) {
            super(itemView);
            txtMovieName = itemView.findViewById(R.id.txt_movie_title);
        }
    }
}
