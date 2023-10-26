package com.example.aplicacion_turimos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Paquetesturisticos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paquetesturisticos);
    }
    public void login(View v) {

        Intent i = new Intent(this, Registrarpaquete.class);
        startActivity(i);
    }

    public void crearpaquete (View v){
        Intent i = new Intent(this, Registrarpaquete.class);
        startActivity(i);
    }
}

