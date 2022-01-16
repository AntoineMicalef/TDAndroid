package com.example.tpandroidstudio.utils;

import com.example.tpandroidstudio.response.MovieSearchResponse;
import com.example.tpandroidstudio.response.genreResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieAPI {

    //https://api.themoviedb.org/3/search/movie?api_key=c2f0b81a5c391c4d8fa68c03c2560f35&query=Jack+Reacher
    //search for movies
    @GET("/3/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String Key,
            @Query("query") String query,
            @Query("language") String Language
    );
    //https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>&language=en-US&page=1
    // Get popular movie
    @GET("3/movie/popular")
    Call<MovieSearchResponse> getPopularMovie(
            @Query("api_key") String Key,
            @Query("language") String language,
            @Query("page") String page
    );
    //Get Upcoming movir
    @GET("3/movie/upcoming")
    Call<MovieSearchResponse> getUpcomingMovie(
            @Query("api_key") String Key,
            @Query("language") String language,
            @Query("page") String page
    );
    //https://api.themoviedb.org/3/genre/movie/list?api_key=c2f0b81a5c391c4d8fa68c03c2560f35&language=en-US
    //https://api.themoviedb.org/3/movie/75780?api_key=c2f0b81a5c391c4d8fa68c03c2560f35&language=en-US
    //Get list of all genres
    @GET("3/movie/{id}")
    Call<genreResponse> getGenre(
            @Path("id") String id,
            @Query("api_key") String Key,
            @Query("language") String language
    );

}
