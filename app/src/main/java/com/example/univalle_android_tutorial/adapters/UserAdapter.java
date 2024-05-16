package com.example.univalle_android_tutorial.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.univalle_android_tutorial.R;
import com.example.univalle_android_tutorial.models.User;
import com.squareup.picasso.Picasso;

import java.util.List;
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private Context context;
    private List<User> movieList;

    public UserAdapter(Context context, List<User> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = movieList.get(position);
        holder.titleTextView.setText(user.first_name);
        holder.overviewTextView.setText(user.last_name);
        holder.releaseDateTextView.setText(String.valueOf(user.id));

        Picasso.get()
                .load(user.avatar)
                .placeholder(R.drawable.ic_launcher_background) // Opcional
                .error(R.drawable.ic_launcher_foreground) // Opcional
                .into(holder.posterImageView);


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterImageView;
        private TextView titleTextView;
        private TextView overviewTextView;
        private TextView releaseDateTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImageView = itemView.findViewById(R.id.poster_image_view);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            overviewTextView = itemView.findViewById(R.id.overview_text_view);
            releaseDateTextView = itemView.findViewById(R.id.release_date_text_view);
        }
    }
}