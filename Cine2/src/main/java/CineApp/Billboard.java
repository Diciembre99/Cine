package CineApp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Billboard implements Serializable {
    private String pelicula;
    private LocalDate inicio;
    private LocalDate finalizacion;
    private Gender genero;
    private AgeCategory pegi;

    // Constructor
    public Billboard(String pelicula, LocalDate inicio, LocalDate finalizacion, Gender genero, AgeCategory pegi) {
        this.pelicula = pelicula;
        this.inicio = inicio;
        this.finalizacion = finalizacion;
        this.genero = genero;
        this.pegi = pegi;
    }

    // Getters y setters (métodos de acceso)
    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(LocalDate finalizacion) {
        this.finalizacion = finalizacion;
    }

    public Gender getGenero() {
        return genero;
    }

    public void setGenero(Gender genero) {
        this.genero = genero;
    }

    public AgeCategory getPegi() {
        return pegi;
    }

    public void setPegi(AgeCategory pegi) {
        this.pegi = pegi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Billboard other = (Billboard) obj;
        if (!Objects.equals(this.pelicula, other.pelicula)) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.finalizacion, other.finalizacion)) {
            return false;
        }
        if (this.genero != other.genero) {
            return false;
        }
        return this.pegi == other.pegi;
    }

    @Override
    public String toString() {
        return "Billboard{" +
                "pelicula='" + pelicula + '\'' +
                ", inicio=" + inicio +
                ", finalizacion=" + finalizacion +
                ", genero=" + genero +
                ", pegi=" + pegi +
                '}';
    }
}
