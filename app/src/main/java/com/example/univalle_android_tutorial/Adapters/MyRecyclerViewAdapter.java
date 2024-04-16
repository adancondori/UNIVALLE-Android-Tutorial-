package com.example.univalle_android_tutorial.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.univalle_android_tutorial.Entity.Person;
import com.example.univalle_android_tutorial.R;


import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private final ArrayList<Person> appData;
    private final LayoutInflater inflateLayout;

    public MyRecyclerViewAdapter(ArrayList<Person> appData, LayoutInflater inflateLayout) {
        this.appData = appData;
        this.inflateLayout = inflateLayout;
    }

    //private ItemClickListener clickListen;
    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflateLayout.inflate(R.layout.row_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.txtTitulo2.setText(appData.get(position).getNombre());
        holder.txtDescripccion2.setText(appData.get(position).getCorreo());
        //
    }

    @Override
    public int getItemCount() {
        return appData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitulo2;
        TextView txtDescripccion2;
        ImageView imgUser;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitulo2 = itemView.findViewById(R.id.txtTitulo2);
            txtDescripccion2 = itemView.findViewById(R.id.txtDescripccion2);
            imgUser = itemView.findViewById(R.id.imgUser);
        }
    }
}
