package com.puretech.daggerexample.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMovieInterface {
    @GET("popular")
    Call<MovieModel> getMovie(@Query("api_key") String api_key
                            , @Query("language") String language,
                              @Query("page") String page);
}
