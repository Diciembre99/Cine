package CineApp;

import java.io.Serializable;
import java.time.LocalDate;

public class Functions implements Serializable {
    private Billboard billboard;
    private LocalDate date;
    private float precio;
    private int sala;

    public Functions(Billboard billboard, LocalDate date, float precio, int sala) {
        this.billboard = billboard;
        this.date = date;
        this.precio = precio;
        this.sala = sala;
    }


    public Billboard getBillboard() {
        return billboard;
    }

    public void setBillboard(Billboard billboard) {
        this.billboard = billboard;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }
}
