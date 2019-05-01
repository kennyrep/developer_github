package com.example.githubdeveloper.api;

import com.example.githubdeveloper.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/search/users?q=language:java+location:ibadan")
    Call<ItemResponse> getItems();
}
