package com.example.tpandroidstudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
// MainActivity4                                                                                //
//      This activity is the search activity                                                    //
//----------------------------------------------------------------------------------------------//
public class MainActivity4 extends AppCompatActivity {
//--- data ---//
    List<MovieModel> listMovies = new ArrayList<>();
    List<MovieModel> listMovies1 = new ArrayList<>();
    List<MovieModel> listMovies2 = new ArrayList<>();
    RecyclerView rvMovie;
    String enter;
    android.content.Context context;
    ApplicationContext app = null;
    MovieAdaptater adapter;
    boolean start = true;
    int total_results;
    int total_pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        context = this;
        app = (ApplicationContext) getApplicationContext();
        rvMovie = (RecyclerView) findViewById(R.id.rvFilms);


        Button B1 = (Button) findViewById(R.id.button);
        Button B2 = (Button) findViewById(R.id.button2);
        Button B3 = (Button) findViewById(R.id.search);
        Button B4 = (Button) findViewById(R.id.button4);
        EditText enterSearch = (EditText) findViewById(R.id.editTextTextMultiLine);

        Intent Upcoming = new Intent(this, MainActivity2.class);
        Intent Popular = new Intent(this, MainActivity.class);
        Intent Language = new Intent(this, Languages.class);


        B2.setOnClickListener(new View.OnClickListener(){// Cahnge to upcoming activity
            @Override
            public void onClick(View view) {
                startActivity(Upcoming);
                finish();
            }
        });
        B1.setOnClickListener(new View.OnClickListener(){ //change to Popular activity
            @Override
            public void onClick(View view) {
                startActivity(Popular);
                finish();
            }
        });
        B3.setOnClickListener(new View.OnClickListener(){ // Make a new search
            @Override
            public void onClick(View view) {
                search(enterSearch.getText());
            }
        });
        B4.setOnClickListener(new View.OnClickListener(){ // Change to Language activity
            @Override
            public void onClick(View view) {
                startActivity(Language);
            }
        });
    }

    //------------------------------------------------------------------------------------------//
    //  search                                                                                  //
    //      Make  search if the text is not empty                                               //
    //------------------------------------------------------------------------------------------//
    private void search(Editable text){
        enter = text.toString();
        if(enter != "")
            GetRetrofitResponse();
    }

    //------------------------------------------------------------------------------------------//
    // GetRetrogitResponse                                                                      //
    //      Function used to make a api Request to receive movies correspond to the search      //
    //------------------------------------------------------------------------------------------//
    private void GetRetrofitResponse(){
        // Make a call
        MovieAPI movieApi = Servicey.getMovieAPI();
        Call<MovieSearchResponse> responseCall = movieApi.searchMovie(
                Credentials.API_KEY,
                enter,
                Credentials.LANGUAGE
        );
        responseCall.enqueue(new Callback<MovieSearchResponse>() {

            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if(response.code() == 200) {//response is call
                    //Save Information
                    listMovies = new ArrayList<>(response.body().getMovies());
                    total_results = response.body().getTotal_pages();
                    total_pages = response.body().getTotal_pages();
                    displayMovie();

                }
                else{
                    try{//error
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

    //----------------------------------------------------------------------------------------//
    // displayMovie                                                                           //
    //      this function is used to dislplay the movies withe the recycler view              //
    //----------------------------------------------------------------------------------------//
    public void displayMovie(){
        int i=0;
        listMovies1.clear();
        listMovies2.clear();
        for(MovieModel movie :listMovies)
        {
            //Make a distribution in tow differents list
            if(i%2 == 0){
                listMovies1.add(movie);
            }
            else{
                listMovies2.add(movie);
            }
            i++;
        }
        if(start == false ){
            rvMovie.removeAllViewsInLayout();
            rvMovie.setAdapter(null);
        }
        //Cretation d'un adaptater avec initialisation du connecteur avec notre liste de film
        adapter = new MovieAdaptater(listMovies1, listMovies2, context, app, enter, total_results, total_pages);
        //On notif au recyclerview notre adapter
        rvMovie.setAdapter((adapter));
        //on déclare quelle type de layoutManager on désire
        rvMovie.setLayoutManager(new LinearLayoutManager(this));
        start = false;
    }
}