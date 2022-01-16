package com.example.tpandroidstudio.utils;

import java.util.List;
//----------------------------------------------------------------------------------//
//  Credentials                                                                     //
//      This class is used to have general api information to make request          //
//----------------------------------------------------------------------------------//
public class Credentials {
    public static final String BASE_URL = "https://api.themoviedb.org";
    public static int PAGE = 1;
    public static final String API_KEY = "c2f0b81a5c391c4d8fa68c03c2560f35";
    public static String LANGUAGE = "fr";
    public static String CATEGORY = "popular";

    public void setLanguage(String LANGUAGE){this.LANGUAGE = LANGUAGE;}
}
