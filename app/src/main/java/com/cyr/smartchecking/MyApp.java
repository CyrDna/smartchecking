package com.cyr.smartchecking;

import android.app.Application;

import com.cyr.smartchecking.Room.PersonDatabase;
public class MyApp extends Application {

    private static PersonDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = PersonDatabase.getInstance(this);
    }
    public static PersonDatabase getDatabase(){
        return database;
    }
}
