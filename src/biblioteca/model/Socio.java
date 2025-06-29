package biblioteca.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Socio {
    private String nombre;
    private String email;
    private String telefono;
    private String id;
    private LocalDate fechaRegistro;

    public Socio(String n, String e, String t, String i) {
        this.nombre = n;
        this.email = e;
        this.telefono = t;
        this.id = i;

        // Fecha de registro al momento de crear el socio
        this.fechaRegistro = LocalDate.now(); 
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

    public void setId(String i) {
        this.id = i;
    }

    public String getId() {
        return this.id;
    }

    public LocalDate getFechaRegistro() {
        return this.fechaRegistro;
    }

    public long diasComoSocio() {
        LocalDate now = LocalDate.now();
        long diff = now.until(this.fechaRegistro, ChronoUnit.DAYS);
        return diff;
    }

    @Override
    public String toString() {
        String res = "";
        res += "Nombre: " + this.nombre + "\n";
        res += "Email: " + this.email + "\n";
        res += "Teléfono: " + this.telefono + "\n";
        res += "ID: " + this.id + "\n";
        res += "Fecha de Registro: " + this.fechaRegistro + " ("+ diasComoSocio() + " días como socio)\n";
        return res;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Socio 
            && this.nombre.equals(((Socio) o).nombre) 
            && this.email.equals(((Socio) o).email)
            && this.telefono.equals(((Socio) o).telefono)
            && this.id.equals(((Socio) o).id)
            && this.fechaRegistro.isEqual(((Socio) o).fechaRegistro);
    }


}