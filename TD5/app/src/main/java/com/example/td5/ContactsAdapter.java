package com.example.td5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private final List<Contact> mContacts;
    public ContactsAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View ContactView = inflater.inflate(R.layout.item_contact, parent, false);

        return new ViewHolder(ContactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);

        TextView firstNameTextView = holder.firstNameTextView;
        firstNameTextView.setText(contact.getNom());

        TextView lastnameTextView = holder.lastnameTextView;
        lastnameTextView.setText(contact.getPrenom());

        ImageView Photo = holder.Photo;
        Glide.with(Photo.getContext()).load(contact.getURLImage()).into(Photo);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView firstNameTextView;
        public TextView lastnameTextView;
        public ImageView Photo;

        public ViewHolder(View itemView)
        {
            super(itemView);
            firstNameTextView = (TextView) itemView.findViewById(R.id.Contact_firstname);
            lastnameTextView = (TextView)  itemView.findViewById(R.id.Contact_lastname);
            Photo = (ImageView) itemView.findViewById(R.id.Contact_Photo);
        }
    }
}
