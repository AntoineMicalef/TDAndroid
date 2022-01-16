package com.example.tpandroidstudio.response;

import com.example.tpandroidstudio.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//this class is used to getting several movies
public class MovieSearchResponse {
    @SerializedName("total_results")
    @Expose
    private int total_count;

    @SerializedName("total_pages")
    @Expose
    private int total_pages;

    @SerializedName("results")
    @Expose
    private List<MovieModel> movies;

    public int getTotal_count() {return total_count;}
    public int getTotal_pages() {return total_pages;}
    public List<MovieModel> getMovies() {return movies;}

    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", total_pages" + total_pages +
                ", movies=" + movies +
                '}';
    }
}
