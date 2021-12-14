package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class exercice extends AppCompatActivity {
    private String login;
    private RecyclerView rvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);

        rvUser = (RecyclerView) findViewById(R.id.rvUser);

        //initialisation des repo
        Intent intent = getIntent();
        GithubService githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);
        //récupération du login de l'activité précédente
        if (intent.hasExtra("login")) {
            login = intent.getStringExtra("login");
        }
        else
        {
            login = "adrienbusin";
        }

        githubService.listRepos(login).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                afficherRepos(response.body());
            }
            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
            }
        });
    }

    public void afficherRepos(List<Repo> repos) {
        ExerciceAdaptater adaptater = new ExerciceAdaptater(repos);
        rvUser.setAdapter(adaptater);
        rvUser.setLayoutManager((new LinearLayoutManager(this)));
    }
}