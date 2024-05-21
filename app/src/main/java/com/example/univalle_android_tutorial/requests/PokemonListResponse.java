package com.example.univalle_android_tutorial.requests;

import com.example.univalle_android_tutorial.models.Pokemon;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PokemonListResponse {
    @SerializedName("results")
    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
