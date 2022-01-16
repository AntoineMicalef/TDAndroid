package com.example.tpandroidstudio.utils;

import java.util.concurrent.atomic.AtomicInteger;

//----------------------------------------------------------------------------------------------//
// Langue                                                                                       //
//      This class is used to mange information of language                                     //
//----------------------------------------------------------------------------------------------//
public class Langue {
    public String Name;
    public String Code;
    public Langue(String Name, String Code){
        this.Name = Name;
        this.Code = Code;
    }
    public String getName() {
        return Name;
    }
}
