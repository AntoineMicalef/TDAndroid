package com.example.tpandroidstudio.response;

import com.example.tpandroidstudio.models.GenreModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
//this class is used to getting several genre
public class genreResponse {
    @SerializedName("genres")
    @Expose
    private List<GenreModel> genres;

    //Getter
    public List<GenreModel> getGenre() {return genres;}

    @Override
    public String toString() {
        return "genreResponse{" +
                "genre=" + genres +
                '}';
    }
}
