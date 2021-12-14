package com.example.diceroller;

import static java.lang.Math.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-- Data to manipulate our object --//
        Button rollButton = (Button) findViewById(R.id.button);
        TextView texteResultat = (TextView) findViewById(R.id.textView);
        TextView texteResultat2 = (TextView) findViewById(R.id.textView2);
        EditText EditionFace = (EditText) findViewById(R.id.editText);

        Random random = new Random();
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //An allert to inform the process f launching dice
               Toast.makeText(MainActivity.this, "Dé lancé!", Toast.LENGTH_SHORT).show();

               //The recuperation of the number of face write in the editor
               Editable face = EditionFace.getText();
               String Sface = face.toString();

               try {//Try withe the Enter of the user

                   //Calculate the result of the throw with a random value wich is maximize at the face get with the editor
                   int res = random.nextInt(Integer.parseInt(Sface))+1;
                   int res2 = random.nextInt(Integer.parseInt(Sface))+1;

                   //Write the result in TexteResult
                   texteResultat.setText(String.valueOf(res));
                   texteResultat2.setText(String.valueOf(res2));
               }
               catch (Exception e) { //If error make the same with a default value
                   //Calculate the result of the throw with a random value wich is maximize at 6
                   int res = random.nextInt(6)+1;
                   int res2 = random.nextInt(6)+1;

                   //Write the result in TexteResult
                   texteResultat.setText(String.valueOf(res));
                   texteResultat2.setText(String.valueOf(res2));
               }
            }
        });
    }
}