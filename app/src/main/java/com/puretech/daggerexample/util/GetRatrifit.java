package com.puretech.daggerexample.util;

import android.app.Activity;
import android.util.Log;

import com.puretech.daggerexample.CustomApplication;
import com.puretech.daggerexample.MainActivity;
import com.puretech.daggerexample.adapter.MovieAdapter;
import com.puretech.daggerexample.model.GetMovieInterface;
import com.puretech.daggerexample.model.MovieData;
import com.puretech.daggerexample.model.MovieModel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetRatrifit  {
    @Inject
    Retrofit retrofit;

    public GetRatrifit(Retrofit retrofit){

      this.retrofit = retrofit;
    }

   public void  callAPI(){
       GetMovieInterface getMovieInterface = retrofit.create(GetMovieInterface.class);
       Call<MovieModel> call = getMovieInterface.getMovie("32a232393cd3771c1bf3868a600e68e4", "en-US", "1");

       call.enqueue(new Callback<MovieModel>() {
           @Override
           public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

               MovieModel movieModel = response.body();

               List<MovieData> movieDataList = movieModel.getData();
               Log.d("Result",""+movieDataList.size());

           }

           @Override
           public void onFailure(Call<MovieModel> call, Throwable t) {

           }
       });
   }

}
