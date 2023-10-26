package com.example.aplicacion_turimos;

import androidx.appcompat.app.AppCompatActivity;
import com.example.aplicacion_turimos.modelos.usuario;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
public class RegistrarCuenta extends AppCompatActivity {
    FirebaseFirestore db;  // Instancia de Firestore
    CollectionReference eUsuario; // Referencia a la colección "usuario"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);
        // Inicializar la instancia de Firestore
        db = FirebaseFirestore.getInstance();

        // Obtener una referencia a la colección "usuario"
        eUsuario = db.collection("usuario");

    }

    public void registrar(View v) {
        //Recuperando al view
        EditText eUsuario = (EditText) findViewById(R.id.eUsuario);
        //Recuperando el valor del  view
        String usuario = eUsuario.getText().toString();
        //Recuperando al view
        EditText etCorreo = (EditText) findViewById(R.id.etCorreo);
        //Recuperando el valor del  view
        String correo = etCorreo.getText().toString();
        //Recuperando al view
        Spinner spCiudad = (Spinner) findViewById(R.id.spCiudad);
        //Recuperando el valor del  view
        String cuidad = spCiudad.getSelectedItem().toString();
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
        usuario nuevoUsuario = new usuario(usuario, correo, cuidad, password,password2);

        // Agregar el nuevo usuario a Firestore
        agregarUsuarioFirestore(nuevoUsuario);
    }

        private void agregarUsuarioFirestore(usuario usuario) {
            // Obtener una referencia a la colección "usuario" (debes crearla previamente en Firestore)
            db.collection("usuario")
                    .add(usuario) // Utiliza .add() para que Firestore genere un ID automáticamente
                    .addOnSuccessListener(documentReference -> {
                        // Registro exitoso, obtén el ID del usuario
                        String usuarioId = documentReference.getId();
                        // Asignar el ID generado automáticamente al atributo _id del usuario
                        usuario.set_Id(usuarioId);

                        // Ahora puedes agregar el objeto usuario con el ID asignado manualmente
                        db.collection("usuario")
                                .document(usuarioId)
                                .set(usuario)
                                .addOnSuccessListener(aVoid -> {
                                    // Registro exitoso
                                    Toast.makeText(this, "Registro exitoso con ID: " + usuarioId, Toast.LENGTH_SHORT).show();

                                    // Guardar el ID del usuario en las preferencias compartidas
                                    SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
                                    SharedPreferences.Editor editor = datos.edit();
                                    editor.putString("_Id", usuarioId); // Guardar el ID del usuario
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

