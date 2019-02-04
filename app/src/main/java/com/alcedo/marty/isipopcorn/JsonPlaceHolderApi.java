package com.alcedo.marty.isipopcorn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("cine.json")
    Call<InitialObject> getInitialObject();
}