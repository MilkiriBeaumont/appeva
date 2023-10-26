package com.example.aplicacion_turimos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Hotelesohostales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelesohostales);
        ImageButton hotel1 = findViewById(R.id.hotel1);
        ImageButton hotel2 = findViewById(R.id.hotel2);
        ImageButton hotel3 = findViewById(R.id.hotel3);

        hotel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Acción a realizar cuando se hace clic en el hotel1
                // Puedes iniciar una nueva actividad o fragmento aquí.
            }
        });

        hotel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Acción a realizar cuando se hace clic en el hotel2
            }
        });

        hotel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Acción a realizar cuando se hace clic en el hotel3
            }
        });



    }
    public void login(View v) {

        Intent i = new Intent(this, Registrarhotelohostal.class);
        startActivity(i);
    }

        public void crearhotel (View v){
        Intent i = new Intent(this, Registrarhotelohostal.class);
        startActivity(i);
    }
}






