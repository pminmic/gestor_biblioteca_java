package com.biblioteca.model;

import java.time.LocalDate;

public class Libro extends Publicacion {
    private String editorial;

    public Libro(String t, int ejem, String id, LocalDate fP, String ed) {
        super(t, ejem, id, fP);
        this.editorial = ed;
    }

    public void setEditorial(String e){
        this.editorial = e;
    }

    public String getEditorial(){
        return this.editorial;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Revista
            && this.titulo.equals(((Libro) o).titulo)
            && this.ejemplares == ((Libro) o).ejemplares
            && this.identificador.equals(((Libro) o).identificador)
            && this.fechaPublicacion.isEqual(((Libro) o).fechaPublicacion)
            && this.editorial.equals(((Libro) o).editorial);
    }
}