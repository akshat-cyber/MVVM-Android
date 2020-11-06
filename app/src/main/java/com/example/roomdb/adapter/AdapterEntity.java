package com.example.roomdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdb.R;
import com.example.roomdb.RoomDB.entitySchemaDB;

import java.util.ArrayList;
import java.util.List;

public class AdapterEntity extends RecyclerView.Adapter<AdapterEntity.HolderEntity> {
    List<entitySchemaDB> data = new ArrayList<>();
    @NonNull
    @Override
    public HolderEntity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new HolderEntity(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderEntity holder, int position) {
        entitySchemaDB currentNode = data.get(position);
        holder.second_name.setText(currentNode.getSecondName());
        holder.first_name.setText(currentNode.getFirstName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void setData (List<entitySchemaDB> data){
        this.data = data;
        notifyDataSetChanged();
    }
    public class HolderEntity extends RecyclerView.ViewHolder{
       private TextView first_name;
        private TextView second_name;
        public HolderEntity(@NonNull View itemView) {
            super(itemView);
            first_name = itemView.findViewById(R.id.first_name);
            second_name = itemView.findViewById(R.id.second_name);
        }
    }
}
