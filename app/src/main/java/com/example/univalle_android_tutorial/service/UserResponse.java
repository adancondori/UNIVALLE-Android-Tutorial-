package com.example.univalle_android_tutorial.service;
import com.example.univalle_android_tutorial.models.User;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {
    @SerializedName("page")
    public int page=0;
    @SerializedName("per_page")
    public int per_page=0;
    @SerializedName("total")
    public int total=0;
    @SerializedName("total_pages")
    public int total_pages=0;
    @SerializedName("data")
    public List<User> data= new ArrayList();

    public List<User> getUser() {
        return data;
    }
}