package biblioteca.model;

import java.time.LocalDate;

public class Revista extends Documento{

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
            && this.getTitulo().equals(((Revista) o).getTitulo())
            && this.getEjemplares() == ((Revista) o).getEjemplares()
            && this.getIdentificador().equals(((Revista) o).getIdentificador())
            && this.getFechaPublicacion().isEqual(((Revista) o).getFechaPublicacion())
            && this.editorial.equals(((Revista) o).editorial);
    }

    @Override
    public String toString(){
        String res = "";
        res += "Titulo: " + this.getTitulo() + "\n";
        res += "Nº ejemplares: " + this.getEjemplares() + "\n";
        res += "ID: " + this.getIdentificador() + "\n";
        res += "Fecha de publicación: " + this.getFechaPublicacion().toString() + "\n";
        res += "Editorial: " + this.editorial + "\n";
        return res;
    }

}    