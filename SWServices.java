package com.example.aspha.swarspedia.API.ApiServices;

import com.example.aspha.swarspedia.Models.Personaje;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SWServices {

    @GET("people/")
    Call<Personaje> getPersonaje(@Query("search") String name);
}
