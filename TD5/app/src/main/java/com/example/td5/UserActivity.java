package com.example.td5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    List<Contact> contacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contact);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // initialisation des contacts
        /*contacts.add(new Contact("Jean", "Pierre"));
        contacts.add(new Contact("Jeanne", "Pierre"));
        contacts.add(new Contact("Pierre", "Pierre"));
        contacts.add(new Contact("Arthur", "Pierre"));
        contacts.add(new Contact("Richard", "Pierre"));
        contacts.add(new Contact("Zinedine", "Zidane"));
        contacts.add(new Contact("Yannick", "Noah"));*/

        // Création d'un adaptater avec initialisation du constructeur avec notre list de contacts
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        //On notifie au recyclerview notre adaptateur
        rvContacts.setAdapter(adapter);
        // On déclare quelle type de layoutManager on désire
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}
