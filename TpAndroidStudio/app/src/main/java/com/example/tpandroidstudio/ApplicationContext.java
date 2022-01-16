package com.example.tpandroidstudio;

import com.example.tpandroidstudio.models.MovieModel;

public class ApplicationContext extends android.app.Application {
    MovieModel mMovie;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mMovie = null;
    }

    public void setmMovie(MovieModel mMovie) {
        this.mMovie = mMovie;
    }

    public MovieModel getmMovie() {
        return mMovie;
    }
}
