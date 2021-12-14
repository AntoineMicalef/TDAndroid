package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());

        // Data to manage object
        Button Login = (Button) findViewById(R.id.buttonLogin);
        EditText EditLogin = (EditText) findViewById(R.id.loginEdit);
        Intent intent = new Intent(this, NewsActivity.class);

        // Add java class
        NewsListApplication app = (NewsListApplication) getApplicationContext();

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Editable Editlog = EditLogin.getText();
                if(Editlog.toString().isEmpty())
                {
                    //Alert to inform the user that he have to enter a name
                    Toast.makeText(LoginActivity.this, "Enter your name !", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Method with  with java class
                    app.setLogin( Editlog.toString());

                    // Method with putExtra
                    //intent.putExtra("login", Editlog.toString());
                    startActivity(intent);
                    finish();// to close the activity
                }
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