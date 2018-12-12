package com.example.aspha.swarspedia.API.Deserializers;

import com.example.aspha.swarspedia.Models.Personaje;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class MyDeseializer implements JsonDeserializer<Personaje> {

    @Override
    public Personaje deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        String name = json.getAsJsonObject().get("name").getAsString();
        String birth_year = json.getAsJsonObject().get("birth_year").getAsString();
        String gender = json.getAsJsonObject().get("gender").getAsString();

        Personaje personaje = new Personaje(name,birth_year,gender);
        return personaje;
    }
}
