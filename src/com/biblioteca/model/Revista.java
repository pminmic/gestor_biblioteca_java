package com.biblioteca.model;

import java.time.LocalDate;

public class Revista extends Publicacion{

    private String editorial;
    
    public Revista(String t, int ejem, String id, LocalDate fP, String ed){
        super(t, ejem, id, fP);
        this.editorial = ed;
    }

    public String getEditorial(){
        return editorial;
    }

    public void setEditorial(String e){
        this.editorial = e;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Revista
            && this.titulo.equals(((Revista) o).titulo)
            && this.ejemplares == ((Revista) o).ejemplares
            && this.identificador.equals(((Revista) o).identificador)
            && this.fechaPublicacion.isEqual(((Revista) o).fechaPublicacion)
            && this.editorial.equals(((Revista) o).editorial);
    }

}    