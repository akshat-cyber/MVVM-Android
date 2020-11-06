package com.example.roomdb.RoomDB;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
// data access object
@Dao
public interface daoDB {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void Insert(entitySchemaDB data); /// data is a particular entity
    @Update
    void updateAll(entitySchemaDB... dataSets);
    @Query("DELETE FROM person")
    void deleteAll();
    @Query("SELECT * FROM person")
    LiveData<List<entitySchemaDB>> getAll();
    @Query("SELECT * FROM person ORDER BY first_name ASC")
    LiveData<List<entitySchemaDB>> getFirstName();
    @Query("SELECT * FROM person ORDER BY second_name ASC")
    LiveData<List<entitySchemaDB>> getSecondName();
    @Query("SELECT * FROM person WHERE first_name LIKE :name")
    public LiveData<List<String>> findWord(String name);
}