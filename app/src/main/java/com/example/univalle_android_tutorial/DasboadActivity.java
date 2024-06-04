package com.example.univalle_android_tutorial;

import android.content.Intent;
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

public class DasboadActivity extends AppCompatActivity {
    TextView user;
    TextView pass;
    SharedPreferencesHelper preferencesHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboad);
        init();
    }
    public void init(){
        user = findViewById(R.id.txt_user);
        pass = findViewById(R.id.txt_pass);
        preferencesHelper = new SharedPreferencesHelper(this);
        String user_logged = preferencesHelper.getString(MainActivity.USER,"");
        String user_pass = preferencesHelper.getString(MainActivity.PASSWORD,"");
        user.setText(user_logged);
        pass.setText(user_pass);
    }

    public void closeSesion(View view) {
        preferencesHelper.clearAll();
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
        finish();
    }
}