package com.example.univalle_android_tutorial.service_pokemon;

import com.example.univalle_android_tutorial.requests.PokemonListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeAPI {
    @GET("/api/v2/pokemon")
    Call<PokemonListResponse> getAllPokemon();
}