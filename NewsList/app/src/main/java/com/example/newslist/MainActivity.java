package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Application;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getLocalClassName());

        // Data to manipulate object
        Button LoginActivityButton = (Button) findViewById(R.id.button3);
        Button NewsActivityButton = (Button) findViewById(R.id.button);
        Button DetailsActivityButton = (Button) findViewById(R.id.button2);
        Intent intentLoginActivity = new Intent(this, LoginActivity.class);
        Intent intentNewsActivity = new Intent(this, NewsActivity.class);
        Intent intentDetailsActivity = new Intent(this, DetailsActivity.class);

        LoginActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(intentLoginActivity);
            }
        });
        NewsActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(intentNewsActivity);
            }
        });
        DetailsActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(intentDetailsActivity);
            }
        });
       /* Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);*/
    }
    public void onBackPressed() {
        super.onBackPressed();
    }
}