package com.example.univalle_android_tutorial.service_pokemon;

import com.example.univalle_android_tutorial.service.UserAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeService {
    private static final String BASE_URL = "https://pokeapi.co/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static PokeAPI pokeAPI = retrofit.create(PokeAPI.class);

    public static PokeAPI getMovieAPI() {
        return pokeAPI;
    }
}