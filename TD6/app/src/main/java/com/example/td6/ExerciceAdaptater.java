package com.example.td6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExerciceAdaptater extends RecyclerView.Adapter<ExerciceAdaptater.ViewHolder> {
    private final List<Repo> mRepo;
    public ExerciceAdaptater(List<Repo> user) {
        mRepo = user;
    }

    private GithubService githubService = new Retrofit.Builder()
            .baseUrl(GithubService.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService.class);
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View UserView= inflater.inflate(R.layout.save,parent,false);
        return new ViewHolder(UserView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repo repo = mRepo.get(position);

        TextView IDTextView = holder.ID;
        TextView NameTextView = holder.Name;
        TextView FullNameTextView = holder.fullName;
        TextView URLTextView = holder.URL;

        IDTextView.setText(repo.getId());
        NameTextView.setText(repo.getName());
        FullNameTextView.setText(repo.getFull_name());
        URLTextView.setText(repo.getHtml_url());
    }

    @Override
    public int getItemCount() {
        return mRepo.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ID;
        public TextView Name;
        public TextView URL;
        public TextView fullName;

        public ViewHolder(View save) {
            super(save);

            ID = (TextView) save.findViewById(R.id.ID);
            Name = (TextView) save.findViewById(R.id.Name);
            fullName = (TextView) save.findViewById(R.id.FullName);
            URL = (TextView) save.findViewById(R.id.Url);
        }
    }

}
