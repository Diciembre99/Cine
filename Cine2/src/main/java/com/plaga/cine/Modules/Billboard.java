package com.plaga.cine.Modules;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Billboard implements Serializable {
    private String movie;
    private LocalDate start;
    private LocalDate end;
    private Gender gender;
    private AgeCategory pegi;

    // Constructor
    public Billboard(String movie, LocalDate start, LocalDate end, Gender gender, AgeCategory pegi) {
        this.movie = movie;
        this.start = start;
        this.end = end;
        this.gender = gender;
        this.pegi = pegi;
    }

    // Getters y setters (métodos de acceso)
    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
        if (!Objects.equals(this.movie, other.movie)) {
            return false;
        }
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        return this.pegi == other.pegi;
    }

    @Override
    public String toString() {
        return "Billboard{" +
                "pelicula='" + movie + '\'' +
                ", inicio=" + start +
                ", finalizacion=" + end +
                ", genero=" + gender +
                ", pegi=" + pegi +
                '}';
    }
}
