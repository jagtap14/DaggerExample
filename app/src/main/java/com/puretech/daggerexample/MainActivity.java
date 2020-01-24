package com.puretech.daggerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.puretech.daggerexample.adapter.MovieAdapter;
import com.puretech.daggerexample.model.GetMovieInterface;
import com.puretech.daggerexample.model.MovieData;
import com.puretech.daggerexample.model.MovieModel;
import com.puretech.daggerexample.util.GetRatrifit;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Inject
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.recyclerMovie);
        gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        ((CustomApplication) getApplication()).getNetworkComponent().inject(MainActivity.this);

        GetMovieInterface getMovieInterface = retrofit.create(GetMovieInterface.class);
        Call<MovieModel> call = getMovieInterface.getMovie("32a232393cd3771c1bf3868a600e68e4", "en-US", "1");
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                MovieModel movieModel = response.body();

                List<MovieData> movieDataList = movieModel.getData();

                MovieAdapter movieAdapter = new MovieAdapter(movieDataList, MainActivity.this);
                recyclerView.setAdapter(movieAdapter);

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
    }
}
