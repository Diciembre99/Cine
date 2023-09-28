package CineApp;

import java.util.Date;

public class Functions {
    private String movie;
    private Date begin;
    private Date end;
    private AgeCategory ageCategory;
    private Gender gender;


    /**
     * Constructor de valores completos
     * @param movie
     * @param movie
     * @param begin
     * @param end
     * @param ageCategory
     * @param gender
     */
    public Functions(String movie, Date begin, Date end, AgeCategory ageCategory, Gender gender) {
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

    String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

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
}
