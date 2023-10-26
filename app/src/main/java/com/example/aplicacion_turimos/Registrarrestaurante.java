package com.example.aplicacion_turimos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.aplicacion_turimos.modelos.restaurante;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Registrarrestaurante extends AppCompatActivity {
    FirebaseFirestore db;  // Instancia de Firestore
    CollectionReference eRestaurante; // Referencia a la colección "usuario"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarrestaurante);
        // Inicializar la instancia de Firestore
        db = FirebaseFirestore.getInstance();

        // Obtener una referencia a la colección "restaurante"
        eRestaurante = db.collection("restaurante");

    }

    public void registrar(View v) {
        //Recuperando al view
        EditText eRestaurante = (EditText) findViewById(R.id.eRestaurante);
        //Recuperando el valor del  view
        String restaurante = eRestaurante.getText().toString();
        //Recuperando al view
        EditText etCorreo = (EditText) findViewById(R.id.etCorreo);
        //Recuperando el valor del  view
        String correo = etCorreo.getText().toString();
        //Recuperando al view
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        //Recuperando el valor del  view
        String password = etPassword.getText().toString();
        //Recuperando al view
        EditText etPassword2 = (EditText) findViewById(R.id.etPassword);
        //Recuperando el valor del  view
        String password2 = etPassword2.getText().toString();
        if (password.equals(password2)) {
            Toast.makeText(this, "Reguistro con exito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Registro fallido", Toast.LENGTH_SHORT).show();
        }
        // Crear un objeto Usuario con los datos ingresados
        restaurante nuevorestaurante = new restaurante (restaurante, correo, password,password2);

        // Agregar el nuevo usuario a Firestore
        agregarUsuarioFirestore(nuevorestaurante);
    }

    private void agregarUsuarioFirestore(restaurante restaurante) {
        // Obtener una referencia a la colección "usuario" (debes crearla previamente en Firestore)
        db.collection("restaurante")
                .add(restaurante) // Utiliza .add() para que Firestore genere un ID automáticamente
                .addOnSuccessListener(documentReference -> {
                    // Registro exitoso, obtén el ID del restaurante
                    String restauranteId = documentReference.getId();
                    // Asignar el ID generado automáticamente al atributo _id del usuario
                    restaurante.set_Id(restauranteId);

                    // Ahora puedes agregar el objeto usuario con el ID asignado manualmente
                    db.collection("usuario")
                            .document(restauranteId)
                            .set(restaurante)
                            .addOnSuccessListener(aVoid -> {
                                // Registro exitoso
                                Toast.makeText(this, "Registro exitoso con ID: " + restauranteId, Toast.LENGTH_SHORT).show();

                                // Guardar el ID del usuario en las preferencias compartidas
                                SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
                                SharedPreferences.Editor editor = datos.edit();
                                editor.putString("_Id", restauranteId); // Guardar el ID del hotel
                                editor.apply(); // Aplicar los cambios en las preferencias compartidas
                            })
                            .addOnFailureListener(e -> {
                                // Manejo de errores
                                Toast.makeText(this, "Registro fallido: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            });
                })
                .addOnFailureListener(e -> {
                    // Manejo de errores
                    Toast.makeText(this, "Registro fallido: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });

    }}