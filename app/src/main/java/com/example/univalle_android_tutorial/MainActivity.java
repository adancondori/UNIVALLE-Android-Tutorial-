package com.example.univalle_android_tutorial;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.univalle_android_tutorial.helper.SharedPreferencesHelper;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    TextView name;
    TextView email;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    SharedPreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         */
        init();
    }

    public void init(){
        preferencesHelper = new SharedPreferencesHelper(this);
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);
        retrive();
    }
    public void SaveData(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        preferencesHelper.saveString(Name, n);
        preferencesHelper.saveString(Email, e);
    }

    public void clear(View view) {
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);
        name.setText("");
        email.setText("");
    }

    public void Get(View view) {
        retrive();
    }
    public void retrive(){
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);
        name.setText(preferencesHelper.getString(Name, ""));
        email.setText(preferencesHelper.getString(Email, ""));
    }
}
