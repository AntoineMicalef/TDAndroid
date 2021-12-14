package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());

        // Data to manege objet
        Button URLButton = (Button) findViewById(R.id.UrlButton);
        TextView LoginView = (TextView) findViewById(R.id.LoginView);

        /* Method with getIntent
            // recover the login if it was sent
            Intent intent = getIntent();
            String login;
            if (intent.hasExtra("login")) {
                login = intent.getStringExtra("login");
                LoginView.setText("Welcom : "+ login);
            }
        */
        // Method with class java
        NewsListApplication app = (NewsListApplication) getApplicationContext();
        LoginView.setText("Welcom : "+ app.getLogin());

        URLButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String url = "https://news.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                finish();
            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}