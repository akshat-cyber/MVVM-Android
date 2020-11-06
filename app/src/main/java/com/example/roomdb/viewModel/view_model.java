package com.example.roomdb.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdb.RoomDB.entitySchemaDB;
import com.example.roomdb.repo.Repository;

import java.util.List;

public class view_model extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<entitySchemaDB>> allData;
    public view_model(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allData = repository.getAllData();
    }
     public void insert(entitySchemaDB data){
       repository.insert(data);
    }
    public  void deleteAll(){
        repository.deleteAll();
    }
    public void updateAll(entitySchemaDB... entitySchemaDBS){
        repository.updateAll(entitySchemaDBS);
    }
    public LiveData<List<entitySchemaDB>> getAllData(){
       return allData;
    }
}