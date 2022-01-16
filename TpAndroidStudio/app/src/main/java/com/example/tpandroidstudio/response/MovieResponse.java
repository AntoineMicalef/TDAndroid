package com.example.tpandroidstudio.response;

import com.example.tpandroidstudio.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//This class is used for answer to a single movie request
public class MovieResponse {
    // 1- Finding the movie object
    @SerializedName("results")
    @Expose
    private MovieModel movie;

    public MovieModel getMovie(){return movie;}

}
