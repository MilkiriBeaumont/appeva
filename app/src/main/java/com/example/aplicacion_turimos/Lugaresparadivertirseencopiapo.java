package com.example.aplicacion_turimos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lugaresparadivertirseencopiapo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugaresparadivertirseencopiapo);
    }
    public void login(View v) {

        Intent i = new Intent(this, Registrarlugar.class);
        startActivity(i);
    }

    public void crearlugar(View v){
        Intent i = new Intent(this, Registrarlugar.class);
        startActivity(i);
    }
}
