package com.example.univalle_android_tutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.univalle_android_tutorial.helper.SharedPreferencesHelper;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    TextView user;
    TextView pass;
    public static final String mypreference = "mypref";
    public static final String PASSWORD = "password";
    public static final String USER = "user";
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
        String user2 = preferencesHelper.getString(USER, "");
        String pass2 = preferencesHelper.getString(PASSWORD, "");
        if (user2.equals("admin")){
            Intent myIntent = new Intent(this, DasboadActivity.class);
            startActivity(myIntent);
            finish();
        }else {

        }


    }

    public void init(){
        preferencesHelper = new SharedPreferencesHelper(this);
        pass = (TextView) findViewById(R.id.etName);
        user = (TextView) findViewById(R.id.etEmail);
        retrive();
    }
    public void SaveData(View view) {
        String n = pass.getText().toString();
        String e = user.getText().toString();
        preferencesHelper.saveString(PASSWORD, n);
        preferencesHelper.saveString(USER, e);
    }

    public void clear(View view) {
        user.setText("");
        pass.setText("");
    }

    public void Get(View view) {
        retrive();
    }
    public void retrive(){
        pass.setText(preferencesHelper.getString(PASSWORD, ""));
        user.setText(preferencesHelper.getString(USER, ""));
    }

    public void login(View view) {
        String password = pass.getText().toString();
        String username = user.getText().toString();
        preferencesHelper.saveString(USER, username);
        preferencesHelper.saveString(PASSWORD, password);
        if (username.equals("admin")) {
            Intent myIntent = new Intent(this, DasboadActivity.class);
            startActivity(myIntent);
            finish();
        } else {

        }


    }
}
