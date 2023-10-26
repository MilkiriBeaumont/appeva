package com.example.aplicacion_turimos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Restaurante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);
    }
    public void login(View v) {

        Intent i = new Intent(this, Registrarrestaurante.class);
        startActivity(i);
    }

    public void crearrestaurante (View v){
        Intent i = new Intent(this, Registrarrestaurante.class);
        startActivity(i);
    }

}