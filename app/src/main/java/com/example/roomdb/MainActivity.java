package com.example.roomdb;
import androidx.appcompat.app.AppCompatActivity; 
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.roomdb.adapter.AdapterEntity;
import com.example.roomdb.viewModel.view_model;

import java.util.List;

public class MainActivity extends AppCompatActivity {
view_model viewModel;
private RecyclerView recyclerView;
private AdapterEntity adapter;
private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        adapter = new AdapterEntity();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        viewModel = ViewModelProviders.of(this).get(view_model.class); // get instance
        viewModel.getAllData().observe(this, entitySchemaDBS -> {
            // called whenever data changes
            adapter.setData(entitySchemaDBS);
        });
    }
}