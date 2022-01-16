package com.example.tpandroidstudio.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
// This class is used to have all information about movie
public class MovieModel implements Parcelable {
    //Model class for our movie
    private String title;
    private String poster_path;
    private String backdrop_path;
    private String release_date;
    private int id;
    private float vote_average;
    private String overview;

    //Constructer
    public MovieModel(String title,
                      String poster_path,
                      String release_date,
                      int movie_id,
                      float vote_average,
                      String movie_overView,
                      String backdrop_path) {
        this.title = title;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.id = movie_id;
        this.vote_average = vote_average;
        this.overview = movie_overView;
        this.backdrop_path = backdrop_path;
    }

    protected MovieModel(Parcel in) {
        title = in.readString();
        poster_path = in.readString();
        release_date = in.readString();
        id = in.readInt();
        vote_average = in.readFloat();
        overview = in.readString();
        backdrop_path = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }
        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    //Getters
    public String getTitle() {return title;}
    public String getPoster_path() {return poster_path;}
    public String getRelease_date() {return release_date;}
    public int getMovie_id() {return id;}
    public float getVote_average() {return vote_average;}
    public String getMovie_overView() {return overview;}
    public String getMovie_backdrop_path() {return backdrop_path;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(poster_path);
        dest.writeString(release_date);
        dest.writeInt(id);
        dest.writeFloat(vote_average);
        dest.writeString(overview);
        dest.writeString(backdrop_path);
    }
}
