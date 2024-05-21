package com.example.univalle_android_tutorial.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.univalle_android_tutorial.R;
import com.example.univalle_android_tutorial.adapters.PokemonAdapter;
import com.example.univalle_android_tutorial.models.Pokemon;
import com.example.univalle_android_tutorial.requests.PokemonListResponse;
import com.example.univalle_android_tutorial.service.UserResponse;
import com.example.univalle_android_tutorial.service.UserService;
import com.example.univalle_android_tutorial.service_pokemon.PokeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;
    private List<Pokemon> pokemonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pokemon_list);
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         */
        init();
    }

    public void init() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        fetchPokemonData();
    }
    private void fetchPokemonData() {
        Call<PokemonListResponse> call = PokeService.getConexionAPI().getAllPokemon();
        call.enqueue(new Callback<PokemonListResponse>() {
            @Override
            public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                if (response.isSuccessful()) {
                    pokemonList = response.body().getResults();
                    pokemonAdapter = new PokemonAdapter(PokemonListActivity.this, pokemonList);
                    recyclerView.setAdapter(pokemonAdapter);
                }
            }

            @Override
            public void onFailure(Call<PokemonListResponse> call, Throwable t) {
                Log.e("MainActivity", "Error fetching data", t);
            }
        });
    }
}