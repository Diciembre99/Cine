package com.plaga.cine.Modules;

import java.io.Serializable;
import java.time.LocalDate;

public class Functions implements Serializable {
    private Billboard billboard;
    private LocalDate date;
    private int hour;
    private int min;
    private float precio;
    private int sala;

    public Functions(Billboard billboard, LocalDate date, float precio, int sala,int hour,int min) {
        this.billboard = billboard;
        this.date = date;
        this.precio = precio;
        this.sala = sala;
        this.hour = hour;
        this.min = min;
    }


    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
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

    @Override
    public String toString() {
        return "Functions{" +
                "billboard=" + billboard +
                ", date=" + date +
                ", precio=" + precio +
                ", sala=" + sala +
                '}';
    }
}
