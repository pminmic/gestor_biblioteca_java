package com.biblioteca.model;

public class Socio {
    private String nombre;
    private String email;
    private String telefono;

    public Socio() {
        this.nombre = "";
        this.email = "";
        this.telefono = "";
    }

    public Socio(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setEmail(String e){
        this.email = e;
    }

    public String getEmail() {
        return this.email;
    }

    public void setTelefono(String t) {
        this.telefono = t;
    }

    public String getTelefono() {
        return this.telefono;
    }

    
}