package com.example.roomdb.RoomDB;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
// entity represents each row in a table
@Entity(tableName = "person")
public class entitySchemaDB {
    @PrimaryKey
    private String uID;
    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "second_name")
    private String secondName;

    public entitySchemaDB(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @NonNull
    public String getuID() {
        return this.uID;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getSecondName() {
        return this.secondName;
    }
}