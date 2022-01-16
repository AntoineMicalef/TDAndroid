package com.example.tpandroidstudio.models;

import android.os.Parcel;
import android.os.Parcelable;
// this classs have information of all genre
public class GenreModel implements Parcelable {
    private int id;
    private String name;

    public GenreModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected GenreModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<GenreModel> CREATOR = new Creator<GenreModel>() {
        @Override
        public GenreModel createFromParcel(Parcel in) {return new GenreModel(in);}
        @Override
        public GenreModel[] newArray(int size) {return new GenreModel[size];}
    };

    public int getId() {return id;}
    public String getName() {return name;}

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
