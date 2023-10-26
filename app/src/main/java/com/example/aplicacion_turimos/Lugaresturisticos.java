package com.example.aplicacion_turimos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lugaresturisticos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugaresturisticos);
    }
    public void login(View v) {

        Intent i = new Intent(this, Registrarlugarturistico.class);
        startActivity(i);
    }

    public void crearCuenta (View v){
        Intent i = new Intent(this, Registrarlugarturistico.class);
        startActivity(i);
    }
}

