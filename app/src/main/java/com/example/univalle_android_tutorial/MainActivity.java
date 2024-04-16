package com.example.univalle_android_tutorial;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.univalle_android_tutorial.Entity.Person;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button btnSave;
    String person_uid;

    Person p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        inicializarFirebase();
        btnSave = findViewById(R.id.button_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (person_uid != null){
                    update(p);
                } else {
                    save();
                }
            }
        });
        person_uid = getIntent().getStringExtra("PERSON_UID");
        if (person_uid != null){
            getPersonFirebase();
        }
    }

    private void getPersonFirebase(){
        DatabaseReference reference = databaseReference.child("Person").child(person_uid);
        reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    DataSnapshot document = task.getResult();
                    p = document.getValue(Person.class);
                    Log.d("UNIVALLE","hola mundo");
                }
            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    public void update(Person p){
        p.setNombre("Jair Anderson");
        p.setApellido("Franco2");
        p.setCorreo("carmen@gmail.com");
        p.setPassword("password");
        databaseReference.
                child("Person").
                child(p.getUid()).
                setValue(p);
        Toast.makeText(this, "Actualizado", Toast.LENGTH_LONG).show();

    }
    public void save(){
        Person p = new Person();
        p.setUid(UUID.randomUUID().toString());
        p.setNombre("Carmen");
        p.setApellido("Cualquiera");
        p.setCorreo("carmen@gmail.com");
        p.setPassword("password");
        databaseReference.
                child("Person").
                child(p.getUid()).
                setValue(p);
        Toast.makeText(this, "Agregado", Toast.LENGTH_LONG).show();

    }
}