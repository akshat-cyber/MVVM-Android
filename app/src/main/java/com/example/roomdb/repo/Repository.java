package com.example.roomdb.repo;
import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.roomdb.RoomDB.daoDB;
import com.example.roomdb.RoomDB.entitySchemaDB;
import com.example.roomdb.RoomDB.roomDB;
import java.util.List;
public class Repository{
    private daoDB dDB;
    private LiveData<List<entitySchemaDB>> allData;
    public Repository(Application application){
        roomDB dataBase = roomDB.getINSTANCE(application);
        dDB = dataBase.db();
        allData = dDB.getAll();
    }
    public LiveData<List<entitySchemaDB>> getAllData() {
        return this.allData;
    }
   public void insert(entitySchemaDB data){
        new InsertAsynchronously(this.dDB).execute(data);
    }
    public   void deleteAll(){
        new DeleteAsynchronously(this.dDB).execute();
    }
    public void updateAll(entitySchemaDB... entitySchemaDBS){
        new UpdateAsynchronously(this.dDB).execute();
    }
    class InsertAsynchronously extends AsyncTask<entitySchemaDB, Void, Void>{
        private daoDB dao;
        InsertAsynchronously(daoDB daoDB){
            this.dao = daoDB;
        }
        @Override
        protected Void doInBackground(entitySchemaDB... entitySchemaDBS) {
            this.dao.Insert(entitySchemaDBS[0]);
            return null;
        }
    }

    class DeleteAsynchronously extends AsyncTask<Void, Void, Void> {
        private daoDB dao;
        DeleteAsynchronously(daoDB daoDB){
            this.dao = daoDB;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            this.dao.deleteAll();
            return null;
        }
    }

    class UpdateAsynchronously extends AsyncTask<entitySchemaDB, Void, Void>{
        private daoDB dao;
        UpdateAsynchronously(daoDB daoDB){
            this.dao = daoDB;
        }
        @Override
        protected Void doInBackground(entitySchemaDB... entitySchemaDBS) {
            this.dao.updateAll(entitySchemaDBS[0]);
            return null;
        }
    }
   public AsyncTask<Void, Void, LiveData<List<entitySchemaDB>>> getFirstName(){
        AsyncTask<Void, Void, LiveData<List<entitySchemaDB>>> data = new getFirstNameAsync(dDB).execute();
        return data;
    }
    class getFirstNameAsync extends AsyncTask<Void, Void, LiveData<List<entitySchemaDB>>>{
        private daoDB daoDB;
        getFirstNameAsync(daoDB daoDB){
            this.daoDB = daoDB;
        }
        @Override
        protected LiveData<List<entitySchemaDB>> doInBackground(Void... voids) {
            LiveData<List<entitySchemaDB>> data = this.daoDB.getFirstName();
            return data;
        }
    }
    public AsyncTask<Void, Void, LiveData<List<entitySchemaDB>>> getSecondName(){
        AsyncTask<Void, Void, LiveData<List<entitySchemaDB>>> data = new getFirstNameAsync(dDB).execute();
        return data;
    }
    class getSecNameAsync extends AsyncTask<Void, Void, LiveData<List<entitySchemaDB>>>{
        private daoDB daoDB;
        getSecNameAsync(daoDB daoDB){
            this.daoDB = daoDB;
        }
        @Override
        protected LiveData<List<entitySchemaDB>> doInBackground(Void... voids) {
            LiveData<List<entitySchemaDB>> data = this.daoDB.getFirstName();
            return data;
        }
    }
   public AsyncTask<String, Void, LiveData<List<String>>> findWord(String name){
       return new FindWord(dDB).execute();
    }
    class FindWord extends AsyncTask<String, Void, LiveData<List<String>>> {
        private daoDB daoDB;
        FindWord(daoDB daoDB){
            this.daoDB = daoDB;
        }
        @Override
        protected LiveData<List<String>> doInBackground(String... strings) {
            LiveData<List<String>> data = this.daoDB.findWord(strings[0]);
            return data;
        }
    }
}