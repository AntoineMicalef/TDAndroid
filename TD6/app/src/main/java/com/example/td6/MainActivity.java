package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button exercice1 = (Button) findViewById(R.id.button1);
        EditText saisie = (EditText) findViewById(R.id.EditText);
        Intent intentExercice = new Intent(this, exercice.class);


        exercice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentExercice.putExtra("login", saisie.getText().toString());
                startActivity(intentExercice);
            }
        });
    }
}