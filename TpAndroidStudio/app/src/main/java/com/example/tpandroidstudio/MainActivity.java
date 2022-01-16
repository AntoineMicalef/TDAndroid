package com.example.tpandroidstudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tpandroidstudio.models.MovieModel;
import com.example.tpandroidstudio.recyclerview.MovieAdaptater;
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


//----------------------------------------------------------------------------------------------//
//  MainActivity2                                                                               //
//      This activity is used to dislay Popular movies                                          //
//----------------------------------------------------------------------------------------------//
public class MainActivity extends AppCompatActivity {
    List<MovieModel> listMovies = new ArrayList<>();
    List<MovieModel> listMovies1 = new ArrayList<>();
    List<MovieModel> listMovies2 = new ArrayList<>();
    RecyclerView rvMovie;
    android.content.Context context;
    ApplicationContext app = null;
    int total_results;
    int total_pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        app = (ApplicationContext) getApplicationContext();
        rvMovie = (RecyclerView) findViewById(R.id.rvFilms);
        GetRetrofitResponse();

        Button B1 = (Button) findViewById(R.id.search);
        Button B2 = (Button) findViewById(R.id.button2);
        Button B4 = (Button) findViewById(R.id.button3);

        Intent Upcoming = new Intent(this, MainActivity2.class);
        Intent search = new Intent(this, MainActivity4.class);
        Intent Language = new Intent(this, Languages.class);


        B2.setOnClickListener(new View.OnClickListener(){// Go to upcomming activity
            @Override
            public void onClick(View view) {
                startActivity(Upcoming);
                finish();
            }
        });
        B4.setOnClickListener(new View.OnClickListener(){// Go to Language activity
            @Override
            public void onClick(View view) {
                startActivity(Language);
            }
        });
        B1.setOnClickListener(new View.OnClickListener(){// go to search activity
            @Override
            public void onClick(View view) {
                startActivity(search);
                finish();
            }
        });

    }
    //------------------------------------------------------------------------------------------//
    // GetRetrofitResponse                                                                      //
    //      Function used to make a api request to get all popular movies                       //
    //------------------------------------------------------------------------------------------//
    private void GetRetrofitResponse(){
        MovieAPI movieApi = Servicey.getMovieAPI();
        Call<MovieSearchResponse> responseCall = movieApi.getPopularMovie(
                Credentials.API_KEY,
                Credentials.LANGUAGE,
                "1"
        );
        responseCall.enqueue(new Callback<MovieSearchResponse>() {

            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if(response.code() == 200) {//response is call
                    listMovies = new ArrayList<>(response.body().getMovies());
                    total_results = response.body().getTotal_pages();
                    total_pages = response.body().getTotal_pages();
                    displayMovie();

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
    //------------------------------------------------------------------------------------------//
    // displayMovie                                                                             //
    //      Function used to displays movies in a recycler view                                 //
    //------------------------------------------------------------------------------------------//
    public void displayMovie(){
        int i=0;
        for(MovieModel movie :listMovies)
        {
            if(i%2 == 0){
                listMovies1.add(movie);
            }
            else{
                listMovies2.add(movie);
            }
            i++;
        }
        //Cretation d'un adaptater avec initialisation du connecteur avec notre liste de film
        MovieAdaptater adapter = new MovieAdaptater(listMovies1, listMovies2, context, app, "pop", total_results, total_pages);
        //On notif au recyclerview notre adapter
        rvMovie.setAdapter((adapter));
        //on déclare quelle type de layoutManager on désire
        rvMovie.setLayoutManager(new LinearLayoutManager(this));
    }
}