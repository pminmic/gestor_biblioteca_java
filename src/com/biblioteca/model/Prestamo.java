package com.biblioteca.model;

import java.time.LocalDate;

public class Prestamo {

    // 20 DIAS DE PRESTAMO
    public static long TIEMPO_PRESTAMO = 20;

    private LocalDate fechaPrestamo;
    private LocalDate fechaRetorno;
    private Publicacion prestamo;
    private Socio socio;

    public Prestamo(LocalDate fP, Publicacion p, Socio s){
        this.fechaPrestamo = fP;
        this.prestamo = p;
        this.socio = s;
        this.fechaRetorno = fP.plusDays(TIEMPO_PRESTAMO);
    }

    public Publicacion getPrestamo() {
        //Recordar usar el método toString
        return this.prestamo;
    }

    public LocalDate getFechaPrestamo() {
        return this.fechaPrestamo;
    }

    public LocalDate getFechaRetorno() {
        return this.fechaRetorno;
    }

    public Socio getSocio() {
        return this.socio;
    }

    public void renovarRetorno() {
        this.fechaRetorno = this.fechaRetorno.plusDays(TIEMPO_PRESTAMO);
    }

    // Finalizar una vez tenga Publicacion y hijos
    @Override
    public String toString() {
        String res = "";
        res += "";        
        return res;
    }

}