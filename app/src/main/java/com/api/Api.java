package com.api;



import com.modellcass.ResponseItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("users")
    Call<ArrayList<ResponseItem>> responeiteam();

    @GET("users/{users_id}")
    Call<ResponseItem> getid(@Path("users_id") int id);










}
