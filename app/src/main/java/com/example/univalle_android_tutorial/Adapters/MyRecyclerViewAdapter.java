package com.example.univalle_android_tutorial.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.univalle_android_tutorial.Entity.Person;
import com.example.univalle_android_tutorial.MainActivity;
import com.example.univalle_android_tutorial.R;


import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private final ArrayList<Person> appData;
    private final LayoutInflater inflateLayout;
    private final Context context;

    public MyRecyclerViewAdapter(ArrayList<Person> appData, LayoutInflater inflateLayout, Context context) {
        this.appData = appData;
        this.inflateLayout = inflateLayout;
        this.context = context;
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
        // ocupado, libre, reservado
        if (appData.get(position).getNombre().equals("ocupado")){
            holder.cardID.setCardBackgroundColor(Color.RED);
        } else if(appData.get(position).getNombre().equals("libre")) {
            holder.cardID.setCardBackgroundColor(Color.WHITE);
        } else if(appData.get(position).getNombre().equals("reservado")) {
            holder.cardID.setCardBackgroundColor(Color.GREEN);
        }
        holder.cardID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (appData.get(position).getNombre().equals("ocupado")){
                    Toast.makeText(context,"Ocupado",Toast.LENGTH_SHORT).show();
                    return;
                } else if (appData.get(position).getNombre().equals("reservado")){
                    Toast.makeText(context,"Reservado",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent (context, MainActivity.class);
                intent.putExtra("PERSON_UID", appData.get(position).getUid());
                context.startActivity(intent);
            }
        });
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
        CardView cardID;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitulo2 = itemView.findViewById(R.id.txtTitulo2);
            txtDescripccion2 = itemView.findViewById(R.id.txtDescripccion2);
            imgUser = itemView.findViewById(R.id.imgUser);
            cardID = itemView.findViewById(R.id.cardID);
        }
    }
}
