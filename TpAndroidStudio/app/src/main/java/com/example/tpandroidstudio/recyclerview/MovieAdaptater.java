package com.example.tpandroidstudio.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tpandroidstudio.ApplicationContext;
import com.example.tpandroidstudio.MainActivity;
import com.example.tpandroidstudio.MainActivity3;
import com.example.tpandroidstudio.R;
import com.example.tpandroidstudio.models.MovieModel;
import com.example.tpandroidstudio.request.Servicey;
import com.example.tpandroidstudio.response.MovieSearchResponse;
import com.example.tpandroidstudio.utils.Credentials;
import com.example.tpandroidstudio.utils.MovieAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieAdaptater extends RecyclerView.Adapter<MovieAdaptater.ViewHolder> {
    private  List<MovieModel> mMovie;
    private  List<MovieModel> mMovie2;
    ApplicationContext app = null;
    private Intent overview = null;
    android.content.Context context;
    String Choix;
    boolean bigger = false;
    private int page = 1;
    int total_results;
    int total_pages;

    public MovieAdaptater(List<MovieModel> movies,
                          List<MovieModel> movies2,
                          android.content.Context context,
                          ApplicationContext app,
                          String choix,
                          int total_results,
                          int total_pages){
        mMovie=movies;
        mMovie2=movies2;
        this.context = context;
        overview = new Intent(context, MainActivity3.class);
        this.app = app;
        this.Choix = choix;
        this.total_results = total_results;
        this.total_pages = total_pages;
    }
    public void clear() {
        mMovie.clear(); // clear list
        mMovie2.clear(); // clear list
        this.notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView Name;
        public TextView Name2;
        public ImageView image;
        public ImageView image2;

        public ViewHolder(View itemView){
            super(itemView);

            Name = (TextView) itemView.findViewById((R.id.FilmName));
            Name2 = (TextView) itemView.findViewById((R.id.FilmName2));
            image = (ImageView) itemView.findViewById(R.id.image);
            image2 = (ImageView) itemView.findViewById(R.id.image2);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View MovieView = inflater.inflate(R.layout.item_movie, parent,false);
        return new ViewHolder(MovieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(total_results > position) {
            if (position >= mMovie.size() - 9 && bigger == false && total_pages >= page) {
                GetRetrofitResponse();
                bigger = true;
            }
            MovieModel movie = mMovie.get(position);
            MovieModel movie2 = mMovie2.get(position);
            ImageView image = holder.image;
            ImageView image2 = holder.image2;

            TextView Name = holder.Name;
            TextView Name2 = holder.Name2;
            Name.setText(movie.getTitle());
            Name2.setText(movie2.getTitle());
            Glide.with(image.getContext()).load("https://image.tmdb.org/t/p/w500/" + movie.getPoster_path()).into(image);
            Glide.with(image2.getContext()).load("https://image.tmdb.org/t/p/w500/" + movie2.getPoster_path()).into(image2);
            image.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             app.setmMovie(movie);
                                             context.startActivity(overview);
                                         }
                                     }
            );
            image2.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              app.setmMovie(movie2);
                                              context.startActivity(overview);
                                          }
                                      }
            );
        }
    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }

    private void GetRetrofitResponse(){
        page ++;
        if(Choix == "pop")
            GetPopular();
        else if (Choix == "upc")
            GetUpcoming();
        else
            searchmovie();

    }
    private void searchmovie(){
        MovieAPI movieApi = Servicey.getMovieAPI();
        Call<MovieSearchResponse> responseCall = movieApi.searchMovie(
                Credentials.API_KEY,
                Choix,
                Credentials.LANGUAGE
        );
        responseCall.enqueue(new Callback<MovieSearchResponse>() {

            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if(response.code() == 200) {//response is call
                    Log.v("Tag", "the response is : " + response.body().toString());
                    List<MovieModel> listMovies = new ArrayList<>(response.body().getMovies());
                    int i = 0;
                    for (MovieModel movie : listMovies) {
                        //Log.v("Tag", "The overview is : " + movie.getTitle());
                        i++;
                        if(i%2==0){
                            mMovie.add(movie);
                            Log.v("Tag", String.valueOf(mMovie.size()));
                        }else{
                            mMovie2.add(movie);
                        }
                    }
                    bigger = false;
                }
                else{
                    try{
                        Log.v("Tag", "Error : " + response.errorBody().string());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
            }
        });
    }
    private void GetPopular(){
        MovieAPI movieApi = Servicey.getMovieAPI();
        Call<MovieSearchResponse> responseCall = movieApi.getUpcomingMovie(
                Credentials.API_KEY,
                Credentials.LANGUAGE,
                String.valueOf(page)
        );
        responseCall.enqueue(new Callback<MovieSearchResponse>() {

            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if(response.code() == 200) {//response is call
                    Log.v("Tag", "the response is : " + response.body().toString());
                    List<MovieModel> listMovies = new ArrayList<>(response.body().getMovies());
                    int i = 0;
                    for (MovieModel movie : listMovies) {
                        //Log.v("Tag", "The overview is : " + movie.getTitle());
                        i++;
                        if(i%2==0){
                            mMovie.add(movie);
                            Log.v("Tag", String.valueOf(mMovie.size()));
                        }else{
                            mMovie2.add(movie);
                        }
                    }
                    bigger = false;
                }
                else{
                    try{
                        Log.v("Tag", "Error : " + response.errorBody().string());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
            }
        });
    }

    private void GetUpcoming(){
        MovieAPI movieApi = Servicey.getMovieAPI();
        Call<MovieSearchResponse> responseCall = movieApi.getPopularMovie(
                Credentials.API_KEY,
                Credentials.LANGUAGE,
                String.valueOf(page)
        );
        responseCall.enqueue(new Callback<MovieSearchResponse>() {

            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if(response.code() == 200) {//response is call
                    Log.v("Tag", "the response is : " + response.body().toString());
                    List<MovieModel> listMovies = new ArrayList<>(response.body().getMovies());
                    int i = 0;
                    for (MovieModel movie : listMovies) {
                        //Log.v("Tag", "The overview is : " + movie.getTitle());
                        i++;
                        if(i%2==0){
                            mMovie.add(movie);
                            Log.v("Tag", String.valueOf(mMovie.size()));
                        }else{
                            mMovie2.add(movie);
                        }
                    }
                    bigger = false;
                }
                else{
                    try{
                        Log.v("Tag", "Error : " + response.errorBody().string());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
            }
        });
    }
}
