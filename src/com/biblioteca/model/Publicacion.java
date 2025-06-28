package com.biblioteca.model;

import java.time.LocalDate;

public abstract class Publicacion {
    public String titulo;
    public int ejemplares;
    public String identificador;
    public LocalDate fechaPublicacion;

    public Publicacion(String t, int ejem, String id, LocalDate fP) {
        this.titulo = t;
        this.ejemplares = ejem;
        this.identificador = id;
        this.fechaPublicacion = fP;
    }

    public void setTitulo(String t) {
        this.titulo = t;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void addEjemplares(int add) {
        this.ejemplares += add;
    }

    public int getEjemplares() {
        return this.ejemplares;
    }

    public void setIdentificador(String id) {
        this.identificador = id;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setFechaPublicacion(LocalDate fP) {
        this.fechaPublicacion = fP;
    }

    public LocalDate getFechaPublicacion() {
        return this.fechaPublicacion;
    }
}