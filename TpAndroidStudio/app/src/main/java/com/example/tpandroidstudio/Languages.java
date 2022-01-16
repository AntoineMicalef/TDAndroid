package com.example.tpandroidstudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tpandroidstudio.recyclerview.LanguageAdaptater;
import com.example.tpandroidstudio.utils.Langue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//----------------------------------------------------------------------------------------------//
//  Languages                                                                                   //
//      This activity is used to dislay all differents language for movies and apply the        //
//      language                                                                                //
//----------------------------------------------------------------------------------------------//
public class Languages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        List<Langue> ListLangue = new ArrayList<>();
        RecyclerView rvLanguage = (RecyclerView) findViewById(R.id.rvLanguage);
        //Set different language
        ListLangue.add(new Langue("French","fr"));
        ListLangue.add(new Langue("English","en"));
        ListLangue.add(new Langue("Portuguese","pt"));
        ListLangue.add(new Langue("Spanish","es"));
        ListLangue.add(new Langue("Deutsch","de"));
        ListLangue.add(new Langue("Japanese","ja"));
        ListLangue.add(new Langue("Russian","ru"));
        ListLangue.add(new Langue("Zulu","zu"));
        ListLangue.add(new Langue("Mongolian","mo"));
        ListLangue.add(new Langue("Cantonese","cn"));
        ListLangue.add(new Langue("Breton","br"));
        ListLangue.add(new Langue("Hindi","hi"));
        ListLangue.add(new Langue("Tibetan","bo"));
        ListLangue.add(new Langue("Irish","ga"));
        ListLangue.add(new Langue("Romanian","ro"));
        ListLangue.add(new Langue("Bulgarian","bg"));
        ListLangue.add(new Langue("Turkish","tr"));
        ListLangue.add(new Langue("Croatian","cr"));
        ListLangue.add(new Langue("Arabic","ar"));
        ListLangue.add(new Langue("Sardinian","sc"));
        ListLangue.add(new Langue("Korean","ko"));
        ListLangue.add(new Langue("Afrikaans","af"));
        ListLangue.add(new Langue("Bosnian","bs"));
        ListLangue.add(new Langue("Tahitian","ty"));
        ListLangue.add(new Langue("Ukrainian","uk"));
        ListLangue.add(new Langue("Albanian","sq"));
        ListLangue.add(new Langue("Slovak","sk"));
        ListLangue.add(new Langue("Vietnamese","vi"));
        ListLangue.add(new Langue("Somali","so"));
        ListLangue.add(new Langue("Maltese","mt"));
        ListLangue.add(new Langue("Italian","it"));
        ListLangue.add(new Langue("Latin","la"));
        // put the list in alphabetic order
        Collections.sort(ListLangue, Comparator.comparing(Langue::getName));

        LanguageAdaptater adaptater = new LanguageAdaptater(ListLangue,this);
        rvLanguage.setAdapter(adaptater);
        rvLanguage.setLayoutManager(new LinearLayoutManager(this));

        Button B1 = (Button) findViewById(R.id.button);
        Button B2 = (Button) findViewById(R.id.button2);
        Intent Upcoming = new Intent(this, MainActivity2.class);
        Intent Popular = new Intent(this, MainActivity.class);

        B2.setOnClickListener(new View.OnClickListener(){ //Go to Upcoming activity
            @Override
            public void onClick(View view) {
                startActivity(Upcoming);
                finish();
            }
        });
        B1.setOnClickListener(new View.OnClickListener(){// Go to Popular activty
            @Override
            public void onClick(View view) {
                startActivity(Popular);
                finish();
            }
        });
    }
}