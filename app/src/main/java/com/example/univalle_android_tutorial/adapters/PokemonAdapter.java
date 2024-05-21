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
import com.example.univalle_android_tutorial.models.Pokemon;
import com.example.univalle_android_tutorial.models.User;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.UserViewHolder> {
    private Context context;
    private List<Pokemon> pokemons;

    public PokemonAdapter(Context context, List<Pokemon> pokemons) {
        this.context = context;
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_pokemon, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Pokemon pokemon = pokemons.get(position);
        holder.titleTextView.setText(pokemon.getName());
        //holder.overviewTextView.setText(user.last_name);
        //holder.releaseDateTextView.setText(String.valueOf(user.id));
        String imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + getPokemonId(pokemon.getUrl()) + ".png";
        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background) // Opcional
                .error(R.drawable.ic_launcher_foreground) // Opcional
                .into(holder.posterImageView);
    }
    private int getPokemonId(String url) {
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }
    @Override
    public int getItemCount() {
        return pokemons.size();
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