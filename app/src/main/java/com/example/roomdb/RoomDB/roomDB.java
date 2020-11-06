package com.example.roomdb.RoomDB;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = daoDB.class, version = 1)
public abstract class roomDB extends RoomDatabase {
     public abstract daoDB db();
     private static roomDB INSTANCE;
     public static synchronized roomDB getINSTANCE(Context context){
         if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                       roomDB.class, "person")
                      .fallbackToDestructiveMigration()
                      .addCallback(callback)
                      .build();
            return INSTANCE;
         }
         return INSTANCE;
     }

     private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){
         @Override
         public void onCreate(@NonNull SupportSQLiteDatabase db) {
             super.onCreate(db);
             new asyncAddData(INSTANCE).execute();
         }

     };
     private static class asyncAddData extends AsyncTask<Void, Void, Void>{
         private daoDB daoDB;
         asyncAddData(roomDB roomDB){
             this.daoDB = roomDB.db();
         }
         @Override
         protected Void doInBackground(Void... voids) {
             this.daoDB.Insert(new entitySchemaDB("akshat", "sahjpal"));
             this.daoDB.Insert(new entitySchemaDB("a", "5543"));
             this.daoDB.Insert(new entitySchemaDB("b", "23"));
             this.daoDB.Insert(new entitySchemaDB("c", "34567"));
             return null;
         }
     }
}
