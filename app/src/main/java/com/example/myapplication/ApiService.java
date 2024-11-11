package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
        @GET("/c/770d-5d61-4fd8-aa99/")
        Call<Books> getBook();

}
