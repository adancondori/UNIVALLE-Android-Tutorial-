package com.example.univalle_android_tutorial;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.univalle_android_tutorial.adapters.UserAdapter;
import com.example.univalle_android_tutorial.models.User;
import com.example.univalle_android_tutorial.service.UserResponse;
import com.example.univalle_android_tutorial.service.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<User> userList;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initAdapter();
        getAllUser();
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         */
    }

    public void initAdapter(){
        userList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(this,userList);
        recyclerView.setAdapter(userAdapter);
    }

    private void getAllUser() {
        Call<UserResponse> call = UserService.getMovieAPI().getAllUser();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    userList.addAll(response.body().getUser());
                    userAdapter.notifyDataSetChanged();
                } else {
                    Log.e("MainActivity", "Error al obtener la lista de películas: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("MainActivity", "Error al obtener la lista de películas: " + t.getMessage());
            }
        });
    }
    private void getUserPerPage() {
        Call<UserResponse> call = UserService.getMovieAPI().getUserPerPage(1,12);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    userList.addAll(response.body().getUser());
                    userAdapter.notifyDataSetChanged();
                } else {
                    Log.e("MainActivity", "Error al obtener la lista de películas: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("MainActivity", "Error al obtener la lista de películas: " + t.getMessage());
            }
        });
    }

    /*
    public void initUsers(){
        userList.add(new User(1,"matatan@gmail.com","Andres","Pereira","https://reqres.in/img/faces/1-image.jpg"));
        userList.add(new User(2,"matatan1@gmail.com","Pero","Pereira","https://reqres.in/img/faces/3-image.jpg"));
        userList.add(new User(3,"matatan2@gmail.com","marco","Pereira","https://reqres.in/img/faces/5-image.jpg"));
        userList.add(new User(4,"matatan3@gmail.com","Juanes","Pereira","https://reqres.in/img/faces/6-image.jpg"));
        userList.add(new User(5,"matatan4@gmail.com","Terry","Pereira","https://reqres.in/img/faces/7-image.jpg"));
        userList.add(new User(6,"matatan5@gmail.com","Valdomero","Pereira","https://reqres.in/img/faces/4-image.jpg"));
        userList.add(new User(7,"matatan6@gmail.com","Juan","Pereira","https://reqres.in/img/faces/4-image.jpg"));
        userList.add(new User(8,"matatan7@gmail.com","Jhon","Pereira","https://reqres.in/img/faces/4-image.jpg"));
        userList.add(new User(9,"matatan@gmail.com","Andres","Pereira","https://reqres.in/img/faces/4-image.jpg"));
    }
 */
}