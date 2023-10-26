package com.example.aplicacion_turimos.modelos;

public class usuario {
    private String _id;  // Este campo corresponderá al ID del documento en Firestore
    private String nombre;
    private String correo;
    private String ciudad;
    private String password;

    private String password2;

    public usuario(String nombre, String correo,  String ciudad, String password,String password2) {
        this.nombre = nombre;
        this.correo = correo;
        this.ciudad = ciudad;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

