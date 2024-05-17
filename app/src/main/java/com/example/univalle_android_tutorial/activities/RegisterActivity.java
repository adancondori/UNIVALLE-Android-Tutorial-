package com.example.univalle_android_tutorial.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.univalle_android_tutorial.R;
import com.example.univalle_android_tutorial.requests.RegisterRequest;
import com.example.univalle_android_tutorial.service.RegisterResponse;
import com.example.univalle_android_tutorial.service.UserResponse;
import com.example.univalle_android_tutorial.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         */
        init();
    }

    public void init(){
        textView = findViewById(R.id.textView);
    }

    public void registerApi(View view){
        registerUser();
    }
    private void registerUser() {
        Call<RegisterResponse> call = UserService.getMovieAPI().registerUser(new RegisterRequest("eve.holt@reqres.in","pistol"));
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    textView.setText(response.body().id + " - " +response.body().token);
                } else {
                    Log.e("MainActivity", "Error al obtener la lista de películas: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.e("MainActivity", "Error al obtener la lista de películas: " + t.getMessage());
            }
        });
    }
}