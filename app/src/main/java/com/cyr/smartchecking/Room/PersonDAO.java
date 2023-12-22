package com.cyr.smartchecking.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import androidx.lifecycle.LiveData;

import java.util.List;

@Dao
public interface PersonDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Person person);
    @Update
    void update(Person person);

    @Query("SELECT * FROM person_table")
    LiveData<List<Person>> getAllPersons();

    @Query("SELECT * FROM person_table WHERE name LIKE :searchText OR sname LIKE :searchText")
    List<Person> searchPersonsByName(String searchText);

}
