package com.example.aspha.swarspedia.API;

import com.example.aspha.swarspedia.API.Deserializers.MyDeseializer;
import com.example.aspha.swarspedia.Models.Personaje;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    public static final String BASE_URL =
            "https://swapi.co/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getAPI(){
        if (retrofit == null){
            GsonBuilder builder= new GsonBuilder();
            builder.registerTypeAdapter(Personaje.class, new MyDeseializer());

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory
                            .create(builder.create()))
                            .build();

        }
        return retrofit;

    }
}
