package com.example.tpandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tpandroidstudio.models.GenreModel;
import com.example.tpandroidstudio.models.MovieModel;
import com.example.tpandroidstudio.request.Servicey;
import com.example.tpandroidstudio.response.MovieSearchResponse;
import com.example.tpandroidstudio.response.genreResponse;
import com.example.tpandroidstudio.utils.Credentials;
import com.example.tpandroidstudio.utils.MovieAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//----------------------------------------------------------------------------------------------//
//  MainActivity3                                                                               //
//      This activity is used to display the information obout one movie                        //
//----------------------------------------------------------------------------------------------//
public class MainActivity3 extends AppCompatActivity {
    MovieModel movie;
    List<GenreModel> listGenre;
    TextView genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //get the context to know the name of the movie selected
        ApplicationContext app = (ApplicationContext) getApplicationContext();
        //get the tittle of the movie
        movie = app.getmMovie();
        //make a api request
        GetRetrofitResponse();

        ImageView image = (ImageView) findViewById(R.id.imageOverview);
        TextView Title = (TextView) findViewById(R.id.textView2);
        TextView overview = (TextView) findViewById(R.id.textView3);
        TextView dateRelease = (TextView) findViewById(R.id.dateRelease);

        Button B1 = (Button) findViewById(R.id.search);
        Button B4 = (Button) findViewById(R.id.button4);

        Intent search = new Intent(this, MainActivity4.class);
        Intent Language = new Intent(this, Languages.class);

        genre = (TextView) findViewById(R.id.genre);
        Title.setText(movie.getTitle());
        overview.setText(movie.getMovie_overView());
        dateRelease.setText(movie.getRelease_date());

        //display the picture of the movie
        Glide.with(image.getContext()).load("https://image.tmdb.org/t/p/w500/" + movie.getMovie_backdrop_path()).into(image);

        B1.setOnClickListener(new View.OnClickListener(){// go to Search activity
            @Override
            public void onClick(View view) {
                startActivity(search);
                finish();
            }
        });
        B4.setOnClickListener(new View.OnClickListener(){ //go to language activity
            @Override
            public void onClick(View view) {
                startActivity(Language);
            }
        });
    }
    //------------------------------------------------------------------------------------------//
    // GetRetrogitResponse                                                                      //
    //      Function used to make a api Request to have information of the movie selected       //
    //------------------------------------------------------------------------------------------//
    private void GetRetrofitResponse(){

        MovieAPI movieApi = Servicey.getMovieAPI();
        Call<genreResponse> responseCall = movieApi.getGenre(
                String.valueOf(movie.getMovie_id()),
                Credentials.API_KEY,
                Credentials.LANGUAGE
        );
        responseCall.enqueue(new Callback<genreResponse>() {

            @Override
            public void onResponse(Call<genreResponse> call, Response<genreResponse> response) {
                if(response.code() == 200) {//response is call
                    listGenre = new ArrayList<>(response.body().getGenre());
                    displayGenre();

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
            public void onFailure(Call<genreResponse> call, Throwable t) {

            }
        });
    }
    //------------------------------------------------------------------------------------------//
    // displayGenre                                                                             //
    //      function used to display genre of movie                                             //
    //------------------------------------------------------------------------------------------//
    public void displayGenre()
    {
        String displaygenre = "";
        for (GenreModel genres : listGenre) {
                displaygenre = displaygenre + System.getProperty ("line.separator")+ "- " + genres.getName();
        }
        genre.setText(displaygenre);
    }
}