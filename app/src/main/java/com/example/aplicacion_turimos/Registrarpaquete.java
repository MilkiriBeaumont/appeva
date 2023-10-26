package com.example.aplicacion_turimos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.aplicacion_turimos.modelos.paquete;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Registrarpaquete extends AppCompatActivity {
    FirebaseFirestore db;  // Instancia de Firestore
    CollectionReference ePaquete; // Referencia a la colección "turistico"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarpaquete);
        // Inicializar la instancia de Firestore
        db = FirebaseFirestore.getInstance();

        // Obtener una referencia a la colección "paquete"
        ePaquete = db.collection("paquete");

    }

    public void registrar(View v) {
        //Recuperando al view
        EditText ePaquete = (EditText) findViewById(R.id.ePaquete);
        //Recuperando el valor del  view
        String paquete = ePaquete.getText().toString();
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
        com.example.aplicacion_turimos.modelos.paquete nuevopaquete = new paquete(paquete, correo, password,password2);

        // Agregar el nuevo usuario a Firestore
        agregarUsuarioFirestore(nuevopaquete);
    }

    private void agregarUsuarioFirestore(paquete paquete) {
        // Obtener una referencia a la colección "usuario" (debes crearla previamente en Firestore)
        db.collection("paquete")
                .add(paquete) // Utiliza .add() para que Firestore genere un ID automáticamente
                .addOnSuccessListener(documentReference -> {
                    // Registro exitoso, obtén el ID del hotel
                    String paqueteId = documentReference.getId();
                    // Asignar el ID generado automáticamente al atributo _id del usuario
                    paquete.set_Id(paqueteId);

                    // Ahora puedes agregar el objeto usuario con el ID asignado manualmente
                    db.collection("paquete")
                            .document(paqueteId)
                            .set(paquete)
                            .addOnSuccessListener(aVoid -> {
                                // Registro exitoso
                                Toast.makeText(this, "Registro exitoso con ID: " + paqueteId, Toast.LENGTH_SHORT).show();

                                // Guardar el ID del usuario en las preferencias compartidas
                                SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
                                SharedPreferences.Editor editor = datos.edit();
                                editor.putString("_Id", paqueteId); // Guardar el ID del hotel
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
