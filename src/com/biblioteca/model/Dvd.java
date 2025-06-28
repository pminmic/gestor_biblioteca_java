package com.biblioteca.model;

import java.time.LocalDate;

public class Dvd extends Publicacion{

    private String productora;

    public Dvd(String t, int ejem, String id, LocalDate tP, String prod) {
        super(t, ejem, id, tP);
        this.productora = prod;
    }

    public void setProductora(String p){
        this.productora = p;
    }

    public String getProductora(){
        return this.productora;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Dvd
            && this.titulo.equals(((Dvd) o).titulo)
            && this.ejemplares == ((Dvd) o).ejemplares
            && this.identificador.equals(((Dvd) o).identificador)
            && this.fechaPublicacion.isEqual(((Dvd) o).fechaPublicacion)
            && this.productora.equals(((Dvd) o).productora);
    }
}