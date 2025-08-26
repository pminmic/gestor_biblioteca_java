package biblioteca.model;

import java.time.LocalDate;

public class Libro extends Documento {
    private String editorial;
    private String autor;

    public Libro(String t, int ejem, String id, LocalDate fP, String ed, String a) {
        super(t, ejem, id, fP);
        this.editorial = ed;
        this.autor = a;
    }

    public void setEditorial(String e){
        this.editorial = e;
    }

    public String getEditorial(){
        return this.editorial;
    }

    public void setAutor(String a){
        this.autor = a;
    }

    public String getAutor(){
        return this.autor;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Revista
            && this.getTitulo().equals(((Libro) o).getTitulo())
            && this.getEjemplares() == ((Libro) o).getEjemplares()
            && this.getIdentificador().equals(((Libro) o).getIdentificador())
            && this.getFechaPublicacion().isEqual(((Libro) o).getFechaPublicacion())
            && this.editorial.equals(((Libro) o).editorial)
            && this.autor.equals(((Libro) o).autor);
    }

    @Override
    public String toString(){
        String res = "";
        res += "Titulo: " + this.getTitulo() + "\n";
        res += "Autor: " + this.autor + "\n";
        res += "Nº ejemplares: " + this.getEjemplares() + "\n";
        res += "ID: " + this.getIdentificador() + "\n";
        res += "Fecha de publicación: " + this.getFechaPublicacion().toString() + "\n";
        res += "Editorial: " + this.editorial + "\n";
        return res;
    }
}