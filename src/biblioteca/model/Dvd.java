package biblioteca.model;

import java.time.LocalDate;

public class Dvd extends Documento{

    private String productora;
    private String director;

    public Dvd(String t, int ejem, String id, LocalDate tP, String prod, String d) {
        super(t, ejem, id, tP);
        this.productora = prod;
        this.director = d;
    }

    public void setProductora(String p){
        this.productora = p;
    }

    public String getProductora(){
        return this.productora;
    }

    public String getDirector(){
        return this.director;
    }

    public void setDirector(String d){
        this.director = d;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Dvd
            && this.getTitulo().equals(((Dvd) o).getTitulo())
            && this.getEjemplares() == ((Dvd) o).getEjemplares()
            && this.getIdentificador().equals(((Dvd) o).getIdentificador())
            && this.getFechaPublicacion().isEqual(((Dvd) o).getFechaPublicacion())
            && this.productora.equals(((Dvd) o).productora)
            && this.director.equals(((Dvd) o).director);
    }

    @Override
    public String toString(){
        String res = "";
        res += "Titulo: " + this.getTitulo() + "\n";
        res += "Director: " + this.director + "\n";
        res += "Nº ejemplares: " + this.getEjemplares() + "\n";
        res += "ID: " + this.getIdentificador() + "\n";
        res += "Fecha de publicación: " + this.getFechaPublicacion().toString() + "\n";
        res += "Productora: " + this.productora + "\n";
        return res;
    }
}