package com.cyr.smartchecking.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class},version = 2 , exportSchema = false)
public abstract class PersonDatabase extends RoomDatabase {
    public static volatile PersonDatabase INSTANCE;
    public abstract PersonDAO getDao();
    public static PersonDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (PersonDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PersonDatabase.class, "person_database")
                           // .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
