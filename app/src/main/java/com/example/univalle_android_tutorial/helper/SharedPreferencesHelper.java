package com.example.univalle_android_tutorial.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    private static final String PREFERENCES_FILE = "com.example.app.PREFERENCE_FILE_KEY";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    // Constructor
    public SharedPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    // Method to save a String value
    public void saveString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    // Method to get a String value
    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    // Method to save an Integer value
    public void saveInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    // Method to get an Integer value
    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    // Method to save a Boolean value
    public void saveBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    // Method to get a Boolean value
    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    // Method to save a Float value
    public void saveFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    // Method to get a Float value
    public float getFloat(String key, float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    // Method to save a Long value
    public void saveLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    // Method to get a Long value
    public long getLong(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    // Method to remove a specific key
    public void removeKey(String key) {
        editor.remove(key);
        editor.commit();
    }

    // Method to clear all preferences
    public void clearAll() {
        editor.clear();
        editor.commit();
    }
}


