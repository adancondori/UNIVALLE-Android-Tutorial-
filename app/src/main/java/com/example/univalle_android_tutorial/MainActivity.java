package com.example.univalle_android_tutorial;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.univalle_android_tutorial.Adapters.MyRecyclerViewAdapter;
import com.example.univalle_android_tutorial.Entidades.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    ArrayList<User> list; //= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
    public void init(){
        LayoutInflater inflateLayout = LayoutInflater.from(getApplicationContext());
        list = new ArrayList<>();
        list.add(new User(1,"Freddy", "To get this working, we have some files for you to download. Two of the files are Java code, while the rest are flag images. The file is a ZIP file",""));
        list.add(new User(1,"Adrian", "To get this working, we have some files for you to download. Two of the files are Java code, while the rest are flag images. The file is a ZIP file",""));
        list.add(new User(1,"Jorge", "To get this working, we have some files for you to download. Two of the files are Java code, while the rest are flag images. The file is a ZIP file",""));
        list.add(new User(1,"Juan", "To get this working, we have some files for you to download. Two of the files are Java code, while the rest are flag images. The file is a ZIP file",""));
        list.add(new User(1,"Carmen", "To get this working, we have some files for you to download. Two of the files are Java code, while the rest are flag images. The file is a ZIP file",""));
        list.add(new User(1,"Diogo", "To get this working, we have some files for you to download. Two of the files are Java code, while the rest are flag images. The file is a ZIP file",""));
        list.add(new User(1,"Angel", "To get this working, we have some files for you to download. Two of the files are Java code, while the rest are flag images. The file is a ZIP file",""));
        adapter = new MyRecyclerViewAdapter(list, inflateLayout);
        recyclerView = findViewById(R.id.rvUsers);
        recyclerView.setLayoutManager( new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

    }
}