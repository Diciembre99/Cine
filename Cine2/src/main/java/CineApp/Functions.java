package CineApp;

import java.io.Serializable;
import java.time.LocalDate;

public class Functions implements Serializable {
    private String movie;
    private LocalDate begin;

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }




    /**
     * Constructor de valores completos
     * @param movie
     * @param begin
     * @param end
     * @param ageCategory
     * @param gender
     */
    public Functions(String movie, LocalDate begin, LocalDate end, AgeCategory ageCategory, Gender gender) {
        this.movie = movie;
        this.begin = begin;
        this.end = end;
        this.ageCategory = ageCategory;
        this.gender = gender;
    }

    /**
     * Constructor vacío
     */
    public Functions() {
    }
    //Getters and Setters


    public void setMovie(String movie) {
        this.movie = movie;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }
    private LocalDate end;
    private AgeCategory ageCategory;
    private Gender gender;
    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return "Functions{" + "Pelicula=" + movie + ", Inicio=" + begin + ", Final=" + end + ", Categoria=" + ageCategory + ", Genero: " + gender + '}';
    }
    
}
