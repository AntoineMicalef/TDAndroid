package com.example.tpandroidstudio.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpandroidstudio.MainActivity;
import com.example.tpandroidstudio.R;
import com.example.tpandroidstudio.utils.Credentials;
import com.example.tpandroidstudio.utils.Langue;

import java.util.List;
//----------------------------------------------------------------------------------------------//
// LanguageAdaptater                                                                            //
//      This class is used to display different language and change the language for the api    //
//      Request                                                                                 //
//----------------------------------------------------------------------------------------------//

public class LanguageAdaptater extends RecyclerView.Adapter<LanguageAdaptater.ViewHolder> {
    private final List<Langue> mLangue;
    private final Context context;

    private Intent popular = null;
    public LanguageAdaptater (List<Langue> Langue, Context context){
        mLangue = Langue;
        this.context = context;
        this.popular = new Intent(context, MainActivity.class);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView Language;
        public FrameLayout FrameLayout;

        public ViewHolder(View item_language){
            super(item_language);

            Language = (TextView) item_language.findViewById(R.id.nomLangue);
            FrameLayout = (android.widget.FrameLayout) item_language.findViewById(R.id.frameLayout);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View LanguageView = inflater.inflate(R.layout.item_languagexml, parent,false);

        return new ViewHolder(LanguageView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Langue langue = mLangue.get(position);

        TextView TextLangue = holder.Language;
        TextLangue.setText(langue.Name);
        android.widget.FrameLayout FrameLayout = holder.FrameLayout;

        // Change the background color
        if(position%2 == 0){
            FrameLayout.setBackgroundColor(Color.BLACK);
        }
        else
        {
            FrameLayout.setBackgroundColor(Color.GRAY);
        }
        // Create a onClick action to change the language of the Api Request
        FrameLayout.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               Credentials.LANGUAGE = langue.Code;
                                               Toast.makeText(context.getApplicationContext(), "Langue change to : " + langue.Name, Toast.LENGTH_LONG).show();
                                               context.startActivity(popular);
                                           }
                                       }
        );
    }

    @Override
    public int getItemCount() {
        return mLangue.size();
    }
}
