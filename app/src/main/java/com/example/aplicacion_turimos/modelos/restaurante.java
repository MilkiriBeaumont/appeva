package com.example.aplicacion_turimos.modelos;

public class restaurante {
    private String _id;  // Este campo corresponderá al ID del documento en Firestore
    private String nombre;
    private String correo;

    private String password;

    private String password2;

    public restaurante (String nombre, String correo, String password,String password2) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.password2 = password2;
        this._id = _id;


    }

    public String get_Id() {
        return _id;
    }

    public void set_Id(String id) {
        this._id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getpassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
