package com.example.aspha.swarspedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aspha.swarspedia.API.API;
import com.example.aspha.swarspedia.API.ApiServices.SWServices;
import com.example.aspha.swarspedia.Models.Personaje;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText search;
    private TextView name;
    private TextView birth_year;
    private TextView gender;
    private Button   enter;
    private SWServices services;
    private Call<Personaje> personajeCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
        services = API.getAPI().create(SWServices.class);
        enter.setOnClickListener(this);
    }

    private void setUI(){
        search = findViewById(R.id.search);
        name = findViewById(R.id.name_tv);
        birth_year = findViewById(R.id.birth_year_tv);
        gender = findViewById(R.id.gender_tv);
        enter = findViewById(R.id.enterbtn);

    }

    @Override
    public void onClick(View v) {
        String name = search.getText().toString();
        if(name!=""){

            personajeCall = services.getPersonaje(name);
          personajeCall.enqueue(new Callback<Personaje>() {
                @Override
                public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                    Personaje personaje = response.body();
                    setResult(personaje);

                }

                @Override
                public void onFailure(Call<Personaje> call, Throwable t) {
                    Log.e("MainActivity", t.getMessage());
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            });
        }





    }
    private void setResult(Personaje personaje){
        name.setText(personaje.getName());
        birth_year.setText(personaje.getBirth_year());
        gender.setText(personaje.getGender());
    }
}
